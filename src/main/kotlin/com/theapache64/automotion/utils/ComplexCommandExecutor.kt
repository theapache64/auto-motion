package com.theapache64.automotion.utils

import mhashim6.commander.main.Appender
import mhashim6.commander.main.CommandBuilder
import mhashim6.commander.main.CommandExecutor
import mhashim6.commander.main.ExecutionOutputPrinter
import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader

/**
 * To execute commands using the shell
 */
object ComplexCommandExecutor {


    /**
     * To execute command
     */
    @Throws(IOException::class)
    fun executeCommand(
        command: String,
        isLivePrint: Boolean,
        isSameLinePrint: (line: String) -> Boolean,
        isNoPrint: (line: String) -> Boolean,
        isSuppressError: Boolean,
        isReturnAll: Boolean,
        prefix: String = "",
        isClearAfterFinish: Boolean = false
    ): List<String> {
        val result = mutableListOf<String>()
        val error = StringBuilder()

        val cmd = CommandBuilder(command)
            .build()

        println("QuickTag: ComplexCommandExecutor:executeCommand: command is '$cmd'")

        var lastPrintedLineLength = 0
        val eop = ExecutionOutputPrinter(object : Appender {
            override fun appendStdText(text: String) {
                println("QuickTag: ComplexCommandExecutor:appendStdText: $text")
                lastPrintedLineLength = text.length
                checkAndPrint(isLivePrint, isSameLinePrint, isNoPrint, text, prefix)
                result.add(text)
            }

            override fun appendErrText(text: String) {
                println("QuickTag: ComplexCommandExecutor:appendErrText: $text")
                lastPrintedLineLength = text.length
                checkAndPrint(isLivePrint, isSameLinePrint, isNoPrint, text, prefix)
                error.append(text).append("\n")
            }
        })


        val pMonitor = CommandExecutor.execute(
            cmd,
            null,
            eop
        ) //execute the command, redirect the output to eop.
        val report = pMonitor.executionReport //blocks until the process finishes or gets aborted.
        cmd.string()
        report.exitValue()

        if (!isSuppressError) {
            if (result.isEmpty() && error.isNotBlank()) {
                // has error
                throw IOException(error.toString())
            }
        }

        if (isReturnAll) {
            result.add(0, error.toString())
        }

        println("QuickTag: ComplexCommandExecutor:executeCommand: error : '$error'")
        println("QuickTag: ComplexCommandExecutor:executeCommand: result : '$result'")

        if (isClearAfterFinish) {
            print("${SpacePrinter.getSpace(lastPrintedLineLength + 2)}\r")
        }
        return result
    }

    private fun checkAndPrint(
        isLivePrint: Boolean,
        isSameLinePrint: (line: String) -> Boolean,
        isNoPrint: (line: String) -> Boolean,
        text: String,
        prefix: String
    ) {
        if (isLivePrint && !isNoPrint(text)) {
            if (isSameLinePrint(text)) {
                print("$prefix$text\r")
            } else {
                println("$prefix$text")
            }
        }
    }
}