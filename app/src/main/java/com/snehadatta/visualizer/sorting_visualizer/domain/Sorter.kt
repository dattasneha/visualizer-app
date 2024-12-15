package com.snehadatta.visualizer.sorting_visualizer.domain

import dagger.hilt.android.AndroidEntryPoint

interface Sorter {
    fun bubbleSort(array: Array<Int>)
}