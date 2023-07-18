package com.example.firm.ui.introView.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.firm.R
import com.example.firm.databinding.FragmentWelcomeBinding

class WelcomeScreen : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentWelcomeBinding.inflate(LayoutInflater.from(inflater.context), container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager)
        binding.content.actionBtn.setOnClickListener {
            viewPager?.currentItem = 1
        }
        binding.content.skipBtn.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
        }
        FirsScreen.bindOnThempScreen(
            binding.content,
            R.drawable.main_logo,
            R.string.title_welcome,
            R.string.desc_welcome
        )

        return binding.root
    }
}
