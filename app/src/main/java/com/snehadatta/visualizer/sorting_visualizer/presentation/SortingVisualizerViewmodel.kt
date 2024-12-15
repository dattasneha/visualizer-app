package com.snehadatta.visualizer.sorting_visualizer.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snehadatta.visualizer.sorting_visualizer.domain.BubbleSort
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class SortingVisualizerViewmodel@Inject constructor(
private val bubbleSort: BubbleSort
) : ViewModel() {
    private val _state = mutableStateOf(SortingState())
    val state: State<SortingState> = _state

    fun bubbleSort(array: Array<Int>) {
        viewModelScope.launch {
            bubbleSort.sort(array).collect {result ->
                _state.value = state.value.copy(
                    elements = result,
                    isSorted = false
                )
            }
            _state.value = state.value.copy(isSorted = true)
        }
    }


}