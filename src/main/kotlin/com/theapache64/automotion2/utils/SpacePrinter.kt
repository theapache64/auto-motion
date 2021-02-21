package com.theapache64.automotion2.utils

object SpacePrinter {
    fun getSpace(count: Int): String {
        val spaces = CharArray(count)
        spaces.fill(' ', 0, count)
        return String(spaces)
    }
}