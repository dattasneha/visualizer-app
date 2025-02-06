package com.snehadatta.visualizer.sorting_visualizer

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.collection.floatListOf
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.snehadatta.visualizer.sorting_visualizer.data.Element
import com.snehadatta.visualizer.sorting_visualizer.presentation.SortingState
import com.snehadatta.visualizer.ui.theme.SortingVisualizerTheme
import com.snehadatta.visualizer.sorting_visualizer.presentation.SortingVisualizerViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Arrays

private val MAX_HEIGHT = 300.dp
private const val MAX_NUMBER = 10000
val doubleList = listOf(200.0, 300.0, 75.0, 160.0, 150.0, 240.0)
val floatList = doubleList.map { it.toFloat() }

@AndroidEntryPoint
class VisualizerActivity : ComponentActivity() {
    private val sortingViewModel: SortingVisualizerViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val arr = arrayOf(2,3,6,5,9,0,1,4)
        val tag = "ArrayDebug"
        sortingViewModel.bubbleSortElements(arr)

        setContent {
            SortingVisualizerTheme {

                val state by sortingViewModel.state.collectAsStateWithLifecycle()
                Log.d(tag, state.elements.toString())

//                Scaffold(modifier = Modifier.fillMaxSize()) {
//
//                }
            }
        }
    }
}

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
                .drawBehind {
                    drawLine(
                        color = borderColor,
                        start = Offset(0f, size.height),
                        end = Offset(size.width, size.height),
                        strokeWidth = strokeWidth
                    )
                    drawLine(
                        color = borderColor,
                        start = Offset(0f, 0f),
                        end = Offset(0f, size.height),
                        strokeWidth = strokeWidth
                    )
                }
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        values.forEach { item ->
            Bar(
                value = item,
                color = borderColor,
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
    val itemHeight  = (value * maxHeight.value / MAX_NUMBER).dp

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

