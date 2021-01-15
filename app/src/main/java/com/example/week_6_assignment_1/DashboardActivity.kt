package com.example.week_6_assignment_1

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.week_6_assignment_1.adapter.ViewPagerAdapter
import com.example.week_6_assignment_1.fragments.AboutFragment
import com.example.week_6_assignment_1.fragments.AddstudentFragment
import com.example.week_6_assignment_1.fragments.HomeFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DashboardActivity : AppCompatActivity() {
    private lateinit var lstTitle : ArrayList<String>
    private lateinit var lstFragments : ArrayList<Fragment>
    private lateinit var viewPager : ViewPager2
    private lateinit var tabLayout : TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)

        populateList()
        val adapter = ViewPagerAdapter(lstFragments, supportFragmentManager, lifecycle)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout,viewPager){ tab, position ->
            tab.text = lstTitle[position]
        }.attach()
    }

    private fun populateList() {
        lstTitle = ArrayList<String>()
        lstTitle.add("Home")
        lstTitle.add("Add Student")
        lstTitle.add("About Us")
        lstFragments = ArrayList<Fragment>()
        lstFragments.add(HomeFragment())
        lstFragments.add(AddstudentFragment())
        lstFragments.add(AboutFragment())
    }
}