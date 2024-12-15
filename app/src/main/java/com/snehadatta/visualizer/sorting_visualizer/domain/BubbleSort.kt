package com.snehadatta.visualizer.sorting_visualizer.domain

import com.snehadatta.visualizer.sorting_visualizer.data.Element
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BubbleSort: Sorter {

    override suspend fun sort(array: Array<Int>): Flow<List<Element>> = flow {
        val n = array.size
        for(i in 0 until n-1) {
            for(j in 0 until n-i-1) {
                if (array[j] >= array[j+1]) {
                    val temp = array[j]
                    array[j] = array[j+1]
                    array[j+1] = temp
                }
                delay(1000L)
                emit(array.map { Element(value = it) })
            }
        }
        delay(1000L)
        emit(array.map { Element(value = it) })
    }

}