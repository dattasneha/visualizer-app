package com.snehadatta.visualizer.sorting_visualizer.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.snehadatta.visualizer.sorting_visualizer.domain.BubbleSort
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class SortingVisualizerViewModel @Inject constructor(
    private val bubbleSort: BubbleSort
) : ViewModel() {

    val arrayElements = mutableStateOf<Array<Int>>(emptyArray())

    private val _state = MutableStateFlow(SortingState())
    val state : StateFlow<SortingState> = _state

    fun bubbleSortElements(array: Array<Int>) {
        arrayElements.value = array
        viewModelScope.launch {
            bubbleSort.sort(array).collect { result ->
                _state.value = result
            }

        }
    }

}