package com.theapache64.automotion.core

import com.google.gson.reflect.TypeToken
import com.theapache64.automotion.core.srtparser.SrtParser
import com.theapache64.automotion.models.AutoSubNode
import com.theapache64.automotion.utils.ComplexCommandExecutor
import com.theapache64.automotion.utils.GsonUtils
import java.io.File
import java.io.FileNotFoundException

/**
 * To do operations related to autosub
 */
object AutoSubUtils {

    private val OUTPUT_REGEX = "Subtitles file created at (.+)".toRegex()

    /**
     * To get subtitle for given video file
     */
    fun getSubFor(
        videoFile: File,
        videoLanguage: String
    ): List<AutoSubNode> {

        val command =
            "autosub --src-language $videoLanguage --dst-language $videoLanguage \"${videoFile.absolutePath}\""

        val autoSubOutput = ComplexCommandExecutor.executeCommand(
            command,
            true,
            { line -> line.contains("Converting") || line.contains("Performing") },
            { line -> line.contains("Subtitles") },
            isSuppressError = true,
            isReturnAll = true,
            prefix = "⏳ "
        ).joinToString("\n")

        val jsonSubFile = parseFile(autoSubOutput)
        require(jsonSubFile.exists()) { "JSON subtitle file doesn't exist ${jsonSubFile.absolutePath}" }
        return getSubFromSrt(jsonSubFile)
    }

    /**
     * To parse AutoSubNode from given json file
     */
    fun parseJson(jsonSubFile: File, videoDuration: Double): List<AutoSubNode> {
        val jsonString = jsonSubFile.readText()
        val typeToken = object : TypeToken<List<AutoSubNode>>() {}.type
        val subNodes = GsonUtils.gson.fromJson<MutableList<AutoSubNode>>(jsonString, typeToken)

        // adding video end
        subNodes.add(AutoSubNode("", videoDuration, videoDuration))

        return subNodes
    }

    /**
     * To parse subtitle file from given autosub output
     */
    private fun parseFile(autoSubOutput: String): File {
        val filePath = OUTPUT_REGEX.find(autoSubOutput)?.groupValues?.get(1)
        require(filePath != null) { "Failed to get file name from autosub output :  $autoSubOutput" }
        return File(filePath)
    }

    fun getSubFromSrt(rawSrt: File): List<AutoSubNode> {
        if (rawSrt.exists()) {
            val parser = SrtParser().parse(rawSrt)
            val autoSubNodes = mutableListOf<AutoSubNode>()
            for (srt in parser.subtitles) {
                autoSubNodes.add(
                    AutoSubNode(
                        srt.text,
                        srt.begin.toSeconds(),
                        srt.end.toSeconds()
                    )
                )
            }
            return autoSubNodes
        } else {
            throw FileNotFoundException(rawSrt.absolutePath)
        }
    }
}