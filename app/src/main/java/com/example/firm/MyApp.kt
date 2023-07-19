package com.example.firm

import android.app.Application
import com.example.firm.di.DbModule
import com.example.firm.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(
                listOf(
                    // Tools
                    DbModule.databaseModule,

                    // ViewModels
                    ViewModelModule.viewModels


                )
            )
        }
    }
}
