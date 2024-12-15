package com.snehadatta.visualizer.sorting_visualizer.presentation

import androidx.lifecycle.ViewModel
import com.snehadatta.visualizer.sorting_visualizer.domain.Sorter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow

import javax.inject.Inject

@HiltViewModel
class SortingVisualizerViewmodel@Inject constructor(
private val sorter: Sorter
) : ViewModel() {
    

}