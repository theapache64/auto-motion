package com.theapache64.automotion.core

import com.github.theapache64.expekt.should
import org.junit.Test

import java.io.File

class FileUtilsTest {

    @Test
    fun getAudioDurationSuccess() {
        FileUtils.getDuration(File("lab/nervous.mp3")).should.equal(192.052245)
    }

    @Test
    fun testGetAudioDurationsSuccess() {
        FileUtils.getDuration(
            listOf(
                File("lab/nervous.mp3"),
                File("lab/suicidal.mp3")
            )
        ).should.equal(386.063674)
    }

    @Test
    fun getDimensionSuccess() {
        val videoMeta = FileUtils.getDimension(File("lab/lion.mp4"))
        videoMeta.width.should.equal(1280)
        videoMeta.height.should.equal(720)
    }

    @Test
    fun getDimensionMovieSuccess() {
        FileUtils.getDimension(File("lab/comma.mp4")).toString().should.equal("VideoMeta(duration=363.235649, height=360, sampleAspectRatio=1:1, width=640)")
    }

    @Test
    fun testHasSubTitleSuccess() {
        val movieFile = File("lab/lion_srted.mp4")
        FileUtils.hasSubTitle(movieFile).should.`true`
    }


    @Test
    fun testHasSubTitleFailure() {
        val movieFile = File("lab/lion.mp4")
        FileUtils.hasSubTitle(movieFile).should.`false`
    }

    @Test
    fun testParseSubTitleSuccess() {
        val movieFile = File("lab/lion_srted.mp4")
        val subTitleFile = FileUtils.parseSubTitle(movieFile)
        subTitleFile!!.name.should.equal("lion_srted.srt")
    }
}