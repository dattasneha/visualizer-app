package com.snehadatta.visualizer.sorting_visualizer.domain

import com.snehadatta.visualizer.sorting_visualizer.data.Element
import com.snehadatta.visualizer.sorting_visualizer.presentation.SortingState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BubbleSort @Inject constructor(): Sorter {
    override fun sort(array: Array<Int>): Flow<SortingState> = flow {
        val n = array.size
        for(i in 0 until n) {
            for(j in 0 until n-i-1) {
                if (array[j] >= array[j+1]) {
                    val temp = array[j]
                    array[j] = array[j+1]
                    array[j+1] = temp

                    emit(SortingState(array.map { Element(value = it) }))
                    delay(1000)
                }

            }
        }
        emit(SortingState(array.map { Element(value = it) }))
    }

}