package com.example.firm.introView.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.firm.R
import com.example.firm.databinding.FragmentFirsScreenBinding
import com.example.firm.databinding.ModuleScreenThempBinding


class FirsScreen : Fragment() {
    private lateinit var binding: FragmentFirsScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirsScreenBinding.inflate(
            LayoutInflater.from(inflater.context),
            container,
            false
        )
        val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager)
        binding.content.actionBtn.setOnClickListener {
            viewPager?.currentItem = 2
        }
        binding.content.skipBtn.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
        }
        bindOnThempScreen(
            binding.content,
            R.drawable.safe,
            R.string.title_one,
            R.string.desc_one
        )
        return binding.root
    }

    companion object {
        fun bindOnThempScreen(
            root: ModuleScreenThempBinding,
            img: Int,
            title: Int,
            desc: Int
        ) {
            root.image.setImageResource(img)
            root.title.setText(title)
            root.desc.setText(desc)
        }
    }
}