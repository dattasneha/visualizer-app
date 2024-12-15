package com.snehadatta.visualizer.sorting_visualizer.domain

import com.snehadatta.visualizer.sorting_visualizer.data.Element
import kotlinx.coroutines.flow.Flow

interface Sorter {
    suspend fun sort(array: Array<Int>): Flow<List<Element>>
}