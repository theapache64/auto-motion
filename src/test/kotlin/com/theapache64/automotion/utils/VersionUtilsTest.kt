package com.theapache64.automotion.utils

import com.github.theapache64.expekt.should
import org.junit.Test

class VersionUtilsTest {
    @Test
    fun testVersionSuccess() {
        VersionUtils.getVersion().should.equal("v1.0.0-beta01")
    }
}