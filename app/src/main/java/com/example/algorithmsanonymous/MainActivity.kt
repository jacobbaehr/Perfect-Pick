package com.example.algorithmsanonymous

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// val's needed for API implementation
private const val TAG = "MainActivity"
private const val BASE_URL = "https://api.yelp.com/v3/"
private const val API_KEY = "ByqULIICRmITM2YWyQrSKQdiEIzLk413fhmf1x-LQ7Sm7PiJb_qUv8Az2GzFaZ-Q8tPGRPMGkmxAomXlg0oaNgfEJMa7yDFUUgsQe3rIg1PzmUy_zRCWxhi5EYRPYHYx"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create val for each fragment
        val searchFragment = SearchFragment()
        val favoritesFragment = FavoritesFragment()
        val profileFragment = ProfileFragment()

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
    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }


//         ----------------------------------------
//         API FUNCTIONALITY BELOW -- DO NOT DELETE
//         ----------------------------------------
//         NOTE: I was thinking we could put this into some type of function, passing in any parameters we need
//               based on the search.  I commented it out so I could work on the search fragment and start getting
//               text blocks to pull data from (places where user can type)
//         --Chris


    // PURPOSE: Utilize Yelp API to perform searches based on user input (within search fragment)
    private fun searchAPI() {
        val places = mutableListOf<YelpPlaces>()
        val adapter = PlacesAdapter(this, places)
        rvPlaces.adapter = adapter
        rvPlaces.layoutManager = LinearLayoutManager(this)

        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val yelpService = retrofit.create(YelpService::class.java)
        yelpService.search("Bearer $API_KEY","Bar", "Lakeland").enqueue(object : Callback<YelpSearchResult> {


            override fun onResponse(call: Call<YelpSearchResult>, response: Response<YelpSearchResult>) {
                Log.i(TAG, "onResponse $response")
                val body = response.body()
                if (body == null) {
                    Log.w(TAG, "Did not receive valid response body from Yelp API... exiting")
                    return
                }
                places.addAll(body.places)
                adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<YelpSearchResult>, t: Throwable) {
                Log.i(TAG, "onFailure $t")
            }
        })
    }


}