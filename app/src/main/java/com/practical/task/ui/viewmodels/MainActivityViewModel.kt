package com.practical.task.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practical.task.data.repository.local.LocalDiscoveryRepository
import com.practical.task.data.repository.remote.DiscoveryRepository
import com.practical.task.ui.states.HomeScreenState
import com.practical.task.utils.network.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    val localDiscoveryRepository: LocalDiscoveryRepository,
    val remoteRepository: DiscoveryRepository
) : ViewModel() {


    private val _state = MutableStateFlow(HomeScreenState())
    val state get() = _state

    fun loadDiscoveryData() {
        println("Loading...")
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            if(localDiscoveryRepository.isDataStale()) {
                println("Loading from Api")
                remoteRepository.getDiscoveryData().collect { dataState ->
                    when (dataState) {
                        is DataState.Error -> {
                            _state.update { it.copy(isLoading = false) }
                            Log.d("xxx", "Error: ${dataState.exception}")
                        }

                        DataState.Loading -> {
                            _state.update { it.copy(isLoading = true) }
                        }

                        is DataState.Success -> {
                            val page = dataState.data.page
                            val elements = page.elements

                            val banner = elements.find { it.elementType == "banner" }
                            val editorChoice = elements.find { it.elementType == "carousel" }
                            val recommended = elements.find { it.elementType == "classic" }
                            val popular = elements.find { it.elementType == "featured" }
                            val newAudiobooks = elements.find { it.elementType == "group_content" }
                            localDiscoveryRepository.saveDiscoveryData(dataState.data)
                            _state.update {
                                it.copy(
                                    banner = banner,
                                    editorChoice = editorChoice,
                                    recommended = recommended,
                                    popular = popular,
                                    newAudiobooks = newAudiobooks,
                                    isLoading = false
                                )
                            }
                        }
                    }
                }
            }else{
                println("Loading from LocalStorage")
                localDiscoveryRepository.getDiscoveryData().let { dataState ->
                    val page = dataState?.page!!
                    val elements = page.elements

                    val banner = elements.find { it.elementType == "banner" }
                    val editorChoice = elements.find { it.elementType == "carousel" }
                    val recommended = elements.find { it.elementType == "classic" }
                    val popular = elements.find { it.elementType == "featured" }
                    val newAudiobooks = elements.find { it.elementType == "group_content" }

                    _state.update {
                        it.copy(
                            banner = banner,
                            editorChoice = editorChoice,
                            recommended = recommended,
                            popular = popular,
                            newAudiobooks = newAudiobooks,
                            isLoading = false
                        )
                    }
                }
            }
        }
    }
    fun refreshDiscoveryData() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isRefreshing = true)
            // Refresh data logic
            _state.value = _state.value.copy(isRefreshing = false)
        }
    }
}

