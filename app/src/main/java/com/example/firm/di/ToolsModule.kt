package com.example.firm.di

import com.example.firm.repository.Repository
import org.koin.dsl.module

object ToolsModule {
    val tools = module {
        single { Repository(get()) }
    }
}