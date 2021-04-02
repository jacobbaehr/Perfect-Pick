package com.example.algorithmsanonymous

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create val for each fragment
        val searchFragment = SearchFragment()
        val favoritesFragment = FavoritesFragment()
        val profileFragment = ProfileFragment()
        val restarauntFragment = restarauntFragment()

        // Set current fragment to search fragment (primary app functionality)
        makeCurrentFragment(searchFragment)

        // ---------------------
        // Bottom navigation bar
        // ---------------------
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_search -> makeCurrentFragment(searchFragment)
                R.id.nav_favorites -> makeCurrentFragment(favoritesFragment)
                R.id.nav_profile -> makeCurrentFragment(profileFragment)
            }
            true
        }


    }

    // PURPOSE: Creation of fragments
    fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }


}