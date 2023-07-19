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
import com.example.firm.databinding.FragmentThirdScreenBinding
import com.example.firm.util.Constants.SplashShared
import com.example.firm.util.Constants.SplashValue
import com.example.firm.util.fillThePage


class ThirdScreen : Fragment() {
    private lateinit var binding: FragmentThirdScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdScreenBinding.inflate(
            LayoutInflater.from(inflater.context),
            container,
            false
        )
        binding.content.actionBtn.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
            onBoardingFinish()
        }
        binding.content.skipBtn.isVisible = false
        fillThePage(
            binding.content,
            R.drawable.custom,
            R.string.title_third,
            R.string.desc_third
        )
        binding.content.actionBtn.setText(R.string.finish_message)
        return binding.root
    }

    private fun onBoardingFinish() {
        val shared = requireActivity().getSharedPreferences(SplashShared, Context.MODE_PRIVATE)
        val editor = shared.edit()
        editor.putBoolean(SplashValue, true)
        editor.apply()
    }
}
