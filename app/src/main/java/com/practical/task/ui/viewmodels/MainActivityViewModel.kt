package com.practical.task.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practical.task.data.repository.local.LocalDiscoveryRepository
import com.practical.task.data.repository.remote.DiscoveryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    val localDiscoveryRepository: LocalDiscoveryRepository,
    val remoteRepository: DiscoveryRepository
) : ViewModel() {
    private val _isLoading = MutableStateFlow(true)
    val isLoading get() = _isLoading.asStateFlow()

    init {
        viewModelScope.launch {
            delay(500)
            _isLoading.value = false
        }
    }

    fun loadDiscoveryData(){
        viewModelScope.launch {
            remoteRepository.getDiscoveryData().collectLatest {

            }
        }
    }
}