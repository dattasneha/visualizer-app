package com.snehadatta.visualizer.sorting_visualizer.di

import com.snehadatta.visualizer.sorting_visualizer.domain.BubbleSort
import com.snehadatta.visualizer.sorting_visualizer.domain.Sorter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object VisualizerModule {
    @Provides
    @Singleton
    fun provideGetBubbleSorter(): Sorter {
        return BubbleSort()
    }

}