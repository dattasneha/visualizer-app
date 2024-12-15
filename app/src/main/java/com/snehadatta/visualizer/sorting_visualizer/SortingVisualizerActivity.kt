package com.snehadatta.visualizer.sorting_visualizer

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.snehadatta.visualizer.`material-theme`.ui.theme.SortingVisualizerTheme
import com.snehadatta.visualizer.sorting_visualizer.presentation.SortingVisualizerViewmodel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Arrays

@AndroidEntryPoint
class VisualizerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SortingVisualizerTheme {
                val sortingViewModel: SortingVisualizerViewmodel = hiltViewModel()
                val state = sortingViewModel.state.value
                val arr = arrayOf(2,6,3,5)
                LaunchedEffect(arr) {
                    sortingViewModel.bubbleSort(arr)
                }

                val tag = "ArrayDebug"
                Log.d(tag, "${(state.elements)} ")

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)

                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SortingVisualizerTheme {
        Greeting("Android")
    }
}