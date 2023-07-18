package com.example.firm.ui.introView.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.firm.R
import com.example.firm.databinding.FragmentSecondScreenBinding


class SecondScreen : Fragment() {
    private lateinit var binding: FragmentSecondScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondScreenBinding.inflate(LayoutInflater.from(inflater.context),container,false)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager)
        binding.content.actionBtn.setOnClickListener {
            viewPager?.currentItem = 3
        }
        binding.content.skipBtn.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
        }
        FirsScreen.bindOnThempScreen(
            binding.content,
            R.drawable.unlimited,
            R.string.title_two,
            R.string.desc_two
        )
return binding.root
    }
}