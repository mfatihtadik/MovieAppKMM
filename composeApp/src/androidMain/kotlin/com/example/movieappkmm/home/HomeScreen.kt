package com.example.movieappkmm.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults
import androidx.compose.material3.pulltorefresh.pullToRefresh
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieappkmm.Red
import com.example.movieappkmm.domain.model.Movie

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeScreenState,
    loadNextMovies: (Boolean) -> Unit,
    navigateToDetail: (Movie) -> Unit
) {

    val pullToRefreshState = rememberPullToRefreshState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .pullToRefresh(
                state = pullToRefreshState,
                isRefreshing = uiState.refreshing,
                onRefresh = { loadNextMovies(true) }
            )
    ) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            itemsIndexed(
                items = uiState.movies,
                key = { _, movie -> movie.id }
            ) { index, movie ->

                MovieListItem(
                    movie = movie,
                    onMovieClick = { navigateToDetail(movie) }
                )

                // Pagination trigger
                if (index >= uiState.movies.size - 1 &&
                    !uiState.loading &&
                    !uiState.loadFinished
                ) {
                    LaunchedEffect(Unit) {
                        loadNextMovies(false)
                    }
                }
            }

            // Bottom loading (pagination loading)
            if (uiState.loading && uiState.movies.isNotEmpty()) {
                item(span = { GridItemSpan(2) }) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CircularProgressIndicator(
                            color = Red
                        )
                    }
                }
            }
        }

        /*
        PullToRefreshBox(
            state = pullToRefreshState,
            modifier = Modifier.align(alignment = Alignment.TopCenter),
            contentAlignment = Alignment.TopStart,
            onRefresh = {

            },
            isRefreshing = true,
            ) {

        }
        
         */
        /*
        // 🔥 Yeni indicator (Material3)
        PullToRefreshContainer(
            state = pullToRefreshState,
            modifier = Modifier.align(Alignment.TopCenter)
        )

         */

    }
}