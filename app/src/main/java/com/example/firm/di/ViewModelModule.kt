package com.example.firm.di

import com.example.firm.viewModel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModule {
    val viewModels = module {
        viewModel { HomeViewModel(get()) }


    }
}