package com.practical.task.ui.states


import com.practical.task.data.model.Element


data class HomeScreenState(
    val banner: Element? = null,
    val editorChoice: Element? = null,
    val recommended:Element? = null,
    val popular: Element? = null,
    val newAudiobooks: Element? = null,
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false
)
