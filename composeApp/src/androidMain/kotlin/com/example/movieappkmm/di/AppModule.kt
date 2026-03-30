package com.example.movieappkmm.di

import com.example.movieappkmm.detail.DetailViewModel
import com.example.movieappkmm.home.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { params -> DetailViewModel(getMovieUseCase = get(), movieId = params.get()) }
}