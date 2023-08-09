package com.example.firm

import android.app.Application
import com.example.firm.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(
                listOf(
                    DbModule.databaseModule,
                    ToolsModule.tools,
                    ViewModelModule.viewModels
                )
            )
        }
    }
}
