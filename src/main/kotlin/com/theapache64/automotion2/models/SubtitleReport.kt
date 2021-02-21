package com.theapache64.automotion2.models

/**
 * To hold report generated from SubtitleAnalyzer
 */
data class SubtitleReport(
    val totalTimelapseDuration: Double,
    val timelapses: List<Timelapse>,
    val nonTimelapseDuration : List<Double>
)