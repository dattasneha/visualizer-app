package com.snehadatta.visualizer.sorting_visualizer.domain

import com.snehadatta.visualizer.sorting_visualizer.data.Element
import com.snehadatta.visualizer.sorting_visualizer.presentation.SortingState
import kotlinx.coroutines.flow.Flow

interface Sorter {
    fun sort(array: Array<Int>): Flow<SortingState>
}