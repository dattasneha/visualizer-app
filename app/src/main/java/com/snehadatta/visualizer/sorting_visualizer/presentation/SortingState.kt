package com.snehadatta.visualizer.sorting_visualizer.presentation

import com.snehadatta.visualizer.sorting_visualizer.data.Element

data class SortingState (
    val elements: List<Element> = emptyList(),
    val isSorted: Boolean = false
)