package com.example.firm.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    list: ArrayList<Fragment>,
    fm: FragmentManager,
    lifecycle: Lifecycle
) :
    FragmentStateAdapter(fm, lifecycle) {

    private val fragmentList = list

    override fun createFragment(position: Int): Fragment = fragmentList[position]

    override fun getItemCount(): Int = fragmentList.size


}