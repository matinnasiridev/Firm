package com.example.firm.introView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.firm.R
import com.example.firm.introView.screens.FirsScreen
import com.example.firm.introView.screens.SecondScreen
import com.example.firm.introView.screens.ThirdScreen
import com.example.firm.introView.screens.WelcomeScreen

class ViewPagerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        view.findViewById<ViewPager2>(R.id.view_pager).adapter = ViewPagerAdapter(
            arrayListOf(
                WelcomeScreen(),
                FirsScreen(),
                SecondScreen(),
                ThirdScreen()
            ),
            requireActivity().supportFragmentManager,
            lifecycle
        )
        return view
    }
}