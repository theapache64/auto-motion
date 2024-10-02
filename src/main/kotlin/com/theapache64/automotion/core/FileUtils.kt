package com.theapache64.automotion.core

import com.theapache64.automotion.models.FFProbeOutput
import com.theapache64.automotion.models.VideoMeta
import com.theapache64.automotion.utils.GsonUtils
import com.theapache64.automotion.utils.SimpleCommandExecutor
import java.io.File
import java.io.FileNotFoundException

/**
 * Operations related to files
 */
object FileUtils {

    /**
     * To get duration of a media file in seconds
     */
    fun getDuration(file: File): Double {
        if (file.exists()) {
            val command =
                "ffprobe -i \"${file.absolutePath}\" -show_entries format=duration -v quiet -of csv=\"p=0\""
            println("QuickTag: FileUtils:getDuration: '$command'")
            val output =
                SimpleCommandExecutor.executeCommand(command)
            println("QuickTag: FileUtils:getDuration: '$output'")
            return output.toDouble()
        } else {
            throw FileNotFoundException(file.absolutePath)
        }
    }

    /**
     * To get duration of multiple media files in seconds
     */
    fun getDuration(files: List<File>): Double {
        println("QuickTag: FileUtils:getDuration: came")
        var duration = 0.0
        files.forEach { file ->
            duration += getDuration(file)
        }
        return duration.also {
            println("QuickTag: FileUtils:getDuration: dur: $it")
        }
    }

    /**
     * To get video dimensions
     * first = width
     * second = height
     */
    fun getDimension(videoFile: File): VideoMeta {
        val command =
            "/opt/homebrew/bin/ffprobe -v error -select_streams v:0 -show_entries stream=width,height,duration,sample_aspect_ratio -print_format json=c=1 \"${videoFile.absolutePath}\""
        println("QuickTag: FileUtils:getDimension: '$command'")
        val jsonString =
            SimpleCommandExecutor.executeCommand(command)
        val ffProbeOutput = GsonUtils.gson.fromJson(jsonString, FFProbeOutput::class.java)
        return ffProbeOutput.streams.first()
    }

    fun parseSubTitle(inputFile: File): File? {

        return if (hasSubTitle(inputFile)) {
            val subTitleFilePath = "${inputFile.parentFile.absolutePath}/${inputFile.nameWithoutExtension}.srt"
            val command =
                "/opt/homebrew/bin/ffmpeg -y -i \"${inputFile.absolutePath}\" -map 0:s:0 \"$subTitleFilePath\""
            SimpleCommandExecutor.executeCommand(
                command,
                isLivePrint = false,
                isSuppressError = true,
                isReturnAll = true
            )
            val subTitleFile = File(subTitleFilePath)

            if (subTitleFile.exists()) {
                subTitleFile
            } else {
                null
            }

        } else {
            null
        }
    }

    fun hasSubTitle(inputFile: File): Boolean {
        return SimpleCommandExecutor.executeCommand("/opt/homebrew/bin/ffmpeg -i \"${inputFile.absolutePath}\" -c copy -map 0:s -f null - -v 0 -hide_banner && echo \$? || echo \$?\n") == "0"
    }
}