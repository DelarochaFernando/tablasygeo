package com.delarochaf.tablasygeo.windowsize

import android.app.Activity
import androidx.compose.ui.geometry.Size
import android.view.WindowMetrics
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.toComposeRect
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.window.layout.WindowMetricsCalculator

enum class WindowSize {
    Compact,
    Medium,
    Expanded
}

@Composable
fun Activity.rememberWindowSize() : Size {
    val configuration = LocalConfiguration.current

    val windowMetrics = remember(configuration){
        WindowMetricsCalculator.getOrCreate()
            .computeCurrentWindowMetrics(this)
    }

    return windowMetrics.bounds.toComposeRect().size
}

@Composable
fun Activity.rememberWindowSizeClass() : WindowSize{
    val windowSize = rememberWindowSize()

    val windowDpSize = with(LocalDensity.current){
        windowSize.toDpSize()
    }

    return getWindowSizeClass(windowDpSize)
}

fun getWindowSizeClass( windowDpSize: DpSize) : WindowSize = when {

    windowDpSize.width < 0.dp ->
        throw IllegalArgumentException("Dp value can not be  negative")
    windowDpSize.width < 600.dp -> WindowSize.Compact
    windowDpSize.width < 840.dp -> WindowSize.Medium
    else -> WindowSize.Expanded

}