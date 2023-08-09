package com.example.firm.ui.introView.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.firm.R
import com.example.firm.databinding.FragmentSecondScreenBinding
import com.example.firm.util.Constants.SplashShared
import com.example.firm.util.Constants.SplashValue
import com.example.firm.util.fillThePage


class SecondScreen : Fragment() {
    private lateinit var binding: FragmentSecondScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondScreenBinding.inflate(
            LayoutInflater.from(inflater.context),
            container,
            false
        )
        binding.apply {
            content.actionBtn.text = "Finish"
            content.actionBtn.setOnClickListener {
                findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
                onBoardingFinish()
            }
            content.skipBtn.isVisible = false
        }

        fillThePage(
            binding.content,
            R.drawable.unlimited,
            R.string.title_two,
            R.string.desc_two
        )
        return binding.root
    }

    private fun onBoardingFinish() {
        val shared = requireActivity().getSharedPreferences(SplashShared, Context.MODE_PRIVATE)
        val editor = shared.edit()
        editor.putBoolean(SplashValue, true)
        editor.apply()
    }
}