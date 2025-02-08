package com.snehadatta.visualizer.sorting_visualizer.presentation

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.snehadatta.visualizer.ui.theme.SortingVisualizerTheme
import com.snehadatta.visualizer.ui.theme.backgroundDarkMediumContrast
import com.snehadatta.visualizer.ui.theme.inversePrimaryDark
import com.snehadatta.visualizer.ui.theme.inversePrimaryDarkMediumContrast
import com.snehadatta.visualizer.ui.theme.onPrimaryDark
import com.snehadatta.visualizer.ui.theme.onPrimaryDarkMediumContrast
import com.snehadatta.visualizer.ui.theme.onSecondaryDark
import com.snehadatta.visualizer.ui.theme.onSecondaryDarkMediumContrast
import com.snehadatta.visualizer.ui.theme.primaryContainerDark
import com.snehadatta.visualizer.ui.theme.primaryContainerLight
import com.snehadatta.visualizer.ui.theme.primaryContainerLightHighContrast
import com.snehadatta.visualizer.ui.theme.primaryContainerLightMediumContrast
import com.snehadatta.visualizer.ui.theme.primaryDarkMediumContrast
import com.snehadatta.visualizer.ui.theme.secondaryContainerDark
import com.snehadatta.visualizer.ui.theme.secondaryContainerLight
import com.snehadatta.visualizer.ui.theme.surfaceDarkMediumContrast
import com.snehadatta.visualizer.ui.theme.surfaceDimDarkMediumContrast

private val MAX_HEIGHT = 200.dp
private const val MAX_NUMBER = 1000
val doubleList = listOf(200.0, 300.0, 75.0, 160.0, 150.0, 240.0,150.0, 240.0,350.0,400.0)
val floatList = doubleList.map { it.toFloat() }
private val colorArray = arrayOf(primaryDarkMediumContrast,primaryContainerLight,primaryContainerDark,primaryContainerLightMediumContrast,inversePrimaryDark,inversePrimaryDarkMediumContrast,primaryContainerLightHighContrast,secondaryContainerDark,onSecondaryDark,onPrimaryDark,onPrimaryDarkMediumContrast)

@Composable
fun Barchart (
    modifier: Modifier,
    values: List<Float>,
    maxHeight: Dp = MAX_HEIGHT
) {
    val borderColor = MaterialTheme.colorScheme.primary
    val density = LocalDensity.current
    val strokeWidth = with(density) { 1.dp.toPx() }

    Row (
        modifier = modifier.then(
            Modifier
                .fillMaxSize()
                .height(maxHeight)
                .padding(20.dp)
                .drawBehind {
                    drawLine(
                        color = borderColor,
                        start = Offset(0f, size.height),
                        end = Offset(size.width, size.height),
                        strokeWidth = strokeWidth
                    )
                    drawLine(
                        color = secondaryContainerLight,
                        start = Offset(0f, 0f),
                        end = Offset(0f, size.height),
                        strokeWidth = strokeWidth
                    )
                }
        ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        values.forEachIndexed { i,item ->
            val color = colorArray[i]

            Bar(
                value = item,
                color = color,
                maxHeight = MAX_HEIGHT
            )
        }
    }
}

@Composable
fun RowScope.Bar (
    value: Float,
    color: Color,
    maxHeight: Dp
) {
    val itemHeight by animateDpAsState(
        targetValue =  (value * maxHeight.value / MAX_NUMBER).dp,
        animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing),
        label = "barHeightAnimation"
    )

    Spacer(
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .height(itemHeight)
            .weight(1f)
            .background(color)
    )
}
@Preview(showBackground = true)
@Composable
fun BarchartPreview() {
    SortingVisualizerTheme {
        Barchart(
            modifier = Modifier,
            values = floatList,
            maxHeight = MAX_HEIGHT
        )
    }
}