package com.practical.task.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.practical.task.ui.component.AudioBooks
import com.practical.task.ui.component.BannerSection
import com.practical.task.ui.component.CircularIndeterminateProgressBar
import com.practical.task.ui.component.EditorChoiceSection
import com.practical.task.ui.component.PopularContent
import com.practical.task.ui.component.RecommendedBookSection
import com.practical.task.ui.viewmodels.MainActivityViewModel


@Composable
fun HomeScreen(viewModel: MainActivityViewModel) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadDiscoveryData()
    }

    Scaffold { padding ->
        Box(modifier = Modifier.fillMaxSize()) {
            SwipeRefresh(
                state = rememberSwipeRefreshState(isRefreshing = state.isRefreshing),
                onRefresh =  {
                    println("pull to refresh")
                    viewModel.loadDiscoveryData()
                }
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                        .padding(padding),
                    contentPadding = padding
                ) {
                    item {
                        state.banner?.let {
                            BannerSection(it)
                        }
                    }
                    item {
                        state.editorChoice?.let {
                            EditorChoiceSection(it)
                        }
                    }
                    item {
                        if (state.recommended?.componentItems?.isNotEmpty() == true) {
                            RecommendedBookSection(books = state.recommended)
                        }
                    }
                    item {
                        if (state.popular?.componentItems?.isNotEmpty() == true) {
                            PopularContent(state.popular)
                        }
                    }
                    item {
                        if (state.newAudiobooks?.componentItems?.isNotEmpty() == true) {
                            AudioBooks(books = state.newAudiobooks) {}
                        }
                    }
                }
                CircularIndeterminateProgressBar(state.isLoading)
            }
        }
    }
}




