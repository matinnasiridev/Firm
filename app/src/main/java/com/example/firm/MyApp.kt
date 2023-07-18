package com.example.firm

import android.app.Application
import android.util.Log
import android.widget.ImageView
import com.example.firm.util.Const.TAG
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApp : Application() {
    // Injection!
    override fun onCreate() {
        super.onCreate()
        val myModules = module {
            single<ImgLoader> { Pic() }
        }

        startKoin {
            androidContext(this@MyApp)
            modules(myModules)
        }
    }
}

interface ImgLoader {
    fun loader(s: String, imgView: ImageView? = null)
}

class Pic : ImgLoader {
    override fun loader(s: String, imgView: ImageView?) {
        Log.v(TAG, s)
    }
}