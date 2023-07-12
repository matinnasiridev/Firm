package com.example.firm


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firm.util.showToast


class MainView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    companion object {
        const val TAG = "TEstCru"
    }
}