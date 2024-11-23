package com.example.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.fragments.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Initialize views
        viewPager = binding.viewPager
        bottomNavigationView = binding.bottomNavigationView


        // Set up ViewPager2 with adapter
        viewPager.adapter = ViewPagerAdapter(this)

        // Handle BottomNavigationView item selection
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> viewPager.setCurrentItem(0, false) // Directly navigate to Home
                R.id.nav_profile -> viewPager.setCurrentItem(1, false) // Directly navigate to Profile
                R.id.nav_settings -> viewPager.setCurrentItem(2, false) // Directly navigate to Settings
            }
            true
        }

        // Handle ViewPager2 page changes to sync with BottomNavigationView
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> bottomNavigationView.selectedItemId = R.id.nav_home
                    1 -> bottomNavigationView.selectedItemId = R.id.nav_profile
                    2 -> bottomNavigationView.selectedItemId = R.id.nav_settings
                }
            }
        })

        setContentView(binding.root)
    }
}
