package com.theapache64.automotion.core

import com.github.theapache64.expekt.should
import org.junit.Test
import java.io.File

class VideoMergerTest {

    @Test
    fun testMergeVideoSuccess() {

        val lionVideo = File("lab/lion.mp4")
        val inputVideoDuration = FileUtils.getDuration(lionVideo) + FileUtils.getDuration(lionVideo)

        val inputVideos = listOf(
            lionVideo,
            lionVideo
        )

        val outputVideo = VideoMerger.mergeVideo(inputVideos)
        val outputVideoLength = FileUtils.getDuration(outputVideo)

        kotlin.math.floor(inputVideoDuration).should.equal(kotlin.math.floor(outputVideoLength))
    }

    @Test
    fun testMergeVideoDiffFormatFailure() {

        val lionVideo = File("lab/lion.mp4")
        val sharkVideo = File("lab/comma.mp4")
        val inputVideoDuration = FileUtils.getDuration(lionVideo) + FileUtils.getDuration(sharkVideo)

        val inputVideos = listOf(
            lionVideo,
            sharkVideo
        )

        val outputVideo = VideoMerger.mergeVideo(inputVideos)
        val outputVideoLength = FileUtils.getDuration(outputVideo)

        kotlin.math.floor(inputVideoDuration).should.not.equal(kotlin.math.floor(outputVideoLength))
    }
}