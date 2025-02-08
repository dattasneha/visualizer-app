package com.snehadatta.visualizer.sorting_visualizer

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.snehadatta.visualizer.sorting_visualizer.presentation.SortingVisualizerScreen
import com.snehadatta.visualizer.ui.theme.SortingVisualizerTheme
import com.snehadatta.visualizer.sorting_visualizer.presentation.SortingVisualizerViewModel
import dagger.hilt.android.AndroidEntryPoint




@AndroidEntryPoint
class VisualizerActivity : ComponentActivity() {
    private val sortingViewModel: SortingVisualizerViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val arr = arrayOf(200, 300, 75, 160, 150, 240,350,100,400,500)
        val tag = "ArrayDebug"
        sortingViewModel.bubbleSortElements(arr)

        setContent {
            SortingVisualizerTheme {

                val state by sortingViewModel.state.collectAsStateWithLifecycle()
                Log.d(tag, state.elements.toString())
                SortingVisualizerScreen(state.elements,300.dp)
//                Scaffold(modifier = Modifier.fillMaxSize()) {
//
//                }
            }
        }
    }
}

