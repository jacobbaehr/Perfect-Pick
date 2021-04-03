package com.example.algorithmsanonymous

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_search.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create val for each fragment
        val searchFragment = SearchFragment()
        val favoritesFragment = FavoritesFragment()
        val profileFragment = ProfileFragment()
        val restaurantFragment = restarauntFragment()


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

        // Possible way we can set button listeners and switch between fragments (-Chris)

//        RestaurantButton.setOnClickListener {
//            makeCurrentFragment(restaurantFragment)
//        }
//        NightlifeButton.setOnClickListener {
//            makeCurrentFragment(NightlifeFragment())
//        }
//        ActivityButton.setOnClickListener {
//            makeCurrentFragment(ActivityFragment())
//        }
    }


    // PURPOSE: Creation of fragments
    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }


}