package com.snehadatta.visualizer.sorting_visualizer.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.snehadatta.visualizer.sorting_visualizer.data.Element
import com.snehadatta.visualizer.ui.theme.SortingVisualizerTheme
import com.snehadatta.visualizer.ui.theme.onErrorContainerLight
import com.snehadatta.visualizer.ui.theme.primaryContainerDark
import com.snehadatta.visualizer.ui.theme.primaryContainerLight
import com.snehadatta.visualizer.ui.theme.secondaryContainerLight

private val HORIZONTAL_PADDING = 8.dp
private val MAX_HEIGHT = 200.dp
private const val MAX_NUMBER = 1000
private val dropDownItems = arrayOf("BUBBLE SORT","SELECTION SORT","INSERTION SORT","MERGE SORT","QUICK SORT")

@Composable
fun SortingVisualizerScreen(
    values: List<Element>,
    maxHeight: Dp,
    modifier: Modifier
) {
    val floatValues: List<Float> = values.map {it.value.toFloat()}
    var values by remember { mutableStateOf("") }
    val defaultItem = remember {
        mutableStateOf(0)
    }
    var speedSliderPosition = remember { mutableFloatStateOf(0f) }
    var numberOfElementsSliderPosition = remember { mutableFloatStateOf(0f) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        Column {
            Row(
                modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
                .padding(horizontal = HORIZONTAL_PADDING)
                    .background(color = primaryContainerLight, RoundedCornerShape(12.dp)),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = dropDownItems[defaultItem.value],
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 12.dp)
                )
                DropDown(defaultItem)

            }

            SliderWithLabel(0f..10f,2,numberOfElementsSliderPosition)

            Box (
                modifier = Modifier
                    .height(320.dp)
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .padding(horizontal = HORIZONTAL_PADDING)
                    .background(color = secondaryContainerLight, RoundedCornerShape(12.dp))
            )  {

                Barchart(
                    modifier = Modifier,
                    values = floatList,
                    maxHeight = MAX_HEIGHT,
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
                    .padding(horizontal = HORIZONTAL_PADDING),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.width(250.dp)
                ) {
                    SliderWithLabel(1f..9f, 10,speedSliderPosition)
                }
                Button(
                    modifier = Modifier.padding(end = 8.dp),
                    onClick = { /* Action */ }, colors = ButtonDefaults.buttonColors(onErrorContainerLight)) {
                    Text("NEXT")

                }
            }
            TextField(
                value = values,
                onValueChange = { values = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .padding(horizontal = HORIZONTAL_PADDING),
                placeholder = {
                    Text(text = "Enter values...")
                },
                trailingIcon = {
                    if (values.isNotEmpty()) {
                        IconButton(onClick = { values = "" }) {
                            Icon(Icons.Filled.Clear, contentDescription = "Clear text")
                        }
                    }
                }
            )
            Box(
                modifier= Modifier
                .padding(top = 10.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Button(
                    modifier = Modifier,
                    onClick = { /* Action */ }, colors = ButtonDefaults.buttonColors(primaryContainerDark)) {
                    Text("SORT")

                }
            }



        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun SortingVisualizerScreenPreview() {
//    SortingVisualizerTheme {
//        SortingVisualizerScreen(
//            values = emptyList(),
//            maxHeight = 300.dp
//        )
//    }
//}

