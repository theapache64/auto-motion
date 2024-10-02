package com.theapache64.automotion.utils

import java.io.File

object JarUtils {

    fun getJarDir(): String {

        val jarDir = File(
            JarUtils::class.java.protectionDomain.codeSource.location
                .toURI()
        ).parent

        if (jarDir.contains("/out/production") || jarDir.contains("/build/classes/")) {
            return ""
        }

        return "$jarDir/"
    }
}