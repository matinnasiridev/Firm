package com.example.firm.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.firm.R
import com.example.firm.util.Constants.SplashShared
import com.example.firm.util.Constants.SplashTime
import com.example.firm.util.Constants.SplashValue

@SuppressLint("CustomSplashScreen")
class SplashScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Handler(Looper.getMainLooper()).postDelayed({
            if (isOnBoardingFinished()) {
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            } else {
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
            }
        }, SplashTime)

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private fun isOnBoardingFinished(): Boolean {
        val shared = requireActivity().getSharedPreferences(SplashShared, Context.MODE_PRIVATE)
        return shared.getBoolean(SplashValue, false)
    }
}