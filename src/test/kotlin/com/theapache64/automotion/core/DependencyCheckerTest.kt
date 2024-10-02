package com.theapache64.automotion.core

import com.github.theapache64.expekt.should
import org.junit.Test

class DependencyCheckerTest {
    @Test
    fun testFFmpegTestSuccess() {
        DependencyChecker.isFFmpegOkay().should.`true`
    }
}