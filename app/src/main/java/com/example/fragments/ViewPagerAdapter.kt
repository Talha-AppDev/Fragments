package com.example.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeFragment : Fragment(R.layout.fragment_home)
class ProfileFragment : Fragment(R.layout.fragment_profile)
class SettingsFragment : Fragment(R.layout.fragment_settings)

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity)
{
    private val fragments = listOf(HomeFragment(), ProfileFragment(), SettingsFragment())

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}

