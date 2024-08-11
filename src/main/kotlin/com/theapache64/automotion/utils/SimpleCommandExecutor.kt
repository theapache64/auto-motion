package com.theapache64.automotion.utils

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * To execute commands using the shell
 */
object SimpleCommandExecutor {


    @Throws(IOException::class)
    fun executeCommand(command: String): String = executeCommand(command, false)

    @Throws(IOException::class)
    fun executeCommand(command: String, isLivePrint: Boolean): String =
        executeCommands(arrayOf(command), isLivePrint, false, isReturnAll = false).joinToString(separator = "\n")


    @Throws(IOException::class)
    fun executeCommand(
        command: String,
        isLivePrint: Boolean,
        isSuppressError: Boolean,
        isReturnAll: Boolean
    ): String =
        executeCommands(arrayOf(command), isLivePrint, isSuppressError, isReturnAll).joinToString(separator = "\n")


    /**
     * To execute command
     */
    @Throws(IOException::class)
    fun executeCommands(
        commands: Array<String>,
        isLivePrint: Boolean,
        isSuppressError: Boolean,
        isReturnAll: Boolean
    ): List<String> {

        val rt = Runtime.getRuntime()
        val proc = rt.exec(
            arrayOf(
                "/bin/sh", "-c", *commands
            )
        )

        val stdInput = BufferedReader(InputStreamReader(proc.inputStream))
        val stdError = BufferedReader(InputStreamReader(proc.errorStream))

        // Read the output from the command
        // Read the output from the command
        var s: String?
        val result = mutableListOf<String>()
        while (stdInput.readLine().also { s = it } != null) {
            if (isLivePrint) {
                println(s)
            }
            result.add(s!!)
        }

        // Read any errors from the attempted command
        // Read any errors from the attempted command
        val error = StringBuilder()
        while (stdError.readLine().also { s = it } != null) {
            if (isLivePrint) {
                println(s)
            }
            error.append(s).append("\n")
        }

        if (!isSuppressError) {
            if (result.isEmpty() && error.isNotBlank()) {
                // has error
                throw IOException(error.toString())
            }
        }

        if (isReturnAll) {
            result.add(0, error.toString())
        }

        return result
    }
}