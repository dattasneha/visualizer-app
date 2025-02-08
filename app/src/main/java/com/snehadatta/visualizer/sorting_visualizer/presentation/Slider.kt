package com.snehadatta.visualizer.sorting_visualizer.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableFloatState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.snehadatta.visualizer.ui.theme.SortingVisualizerTheme

@Composable
fun SliderWithLabel(
    valueRange: ClosedFloatingPointRange<Float>,
    steps: Int,
    sliderPosition: MutableFloatState
) {

    Column {
        Slider(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            value = sliderPosition.value,
            onValueChange = { sliderPosition.value = it },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            steps = steps,
            valueRange = valueRange
        )
    }
}

