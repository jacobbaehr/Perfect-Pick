package com.example.algorithmsanonymous

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// Vals needed for API implementation
private const val TAG = "MainActivity"
private const val BASE_URL = "https://api.yelp.com/v3/"
private const val API_KEY = "ByqULIICRmITM2YWyQrSKQdiEIzLk413fhmf1x-LQ7Sm7PiJb_qUv8Az2GzFaZ-Q8tPGRPMGkmxAomXlg0oaNgfEJMa7yDFUUgsQe3rIg1PzmUy_zRCWxhi5EYRPYHYx"

class MainActivity2 : AppCompatActivity(), PlacesAdapter.OnItemClickListener{

    val places = mutableListOf<YelpPlaces>()
    val adapter = PlacesAdapter(this, places, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Create val for each fragment on nav bar
        val searchFragment = SearchFragment()
        val favoritesFragment = FavoritesFragment()
        val profileFragment = ProfileFragment()

        // ---------------------
        // Bottom navigation bar
        // ---------------------
        bottom_navigation.setOnNavigationItemSelectedListener {
            // When user clicks on nav bar, initiate transaction to appropriate fragment
            when (it.itemId) {
                R.id.nav_search -> makeCurrentFragment(searchFragment)
                R.id.nav_favorites -> makeCurrentFragment(favoritesFragment)
                R.id.nav_profile -> makeCurrentFragment(profileFragment)
            }
            true
        }

        val intent = intent
        val term = intent.getStringExtra("INPUT_1")
        val location = intent.getStringExtra("INPUT_2")
        val dollars = intent.getStringExtra("INPUT_3")


        //Spin the wheel
        var pick: Button = findViewById(R.id.pick)

        pick.setOnClickListener {
            val wheelIntent = Intent(this, WheelActivity::class.java)
            wheelIntent.putParcelableArrayListExtra("places", ArrayList(places))

//            wheelIntent.putExtra("places0", places?.get(0))
//            wheelIntent.putExtra("places1", places?.get(1))
//            wheelIntent.putExtra("places2", places?.get(2))
//            wheelIntent.putExtra("places3", places?.get(3))
//            wheelIntent.putExtra("places4", places?.get(4))
//            wheelIntent.putExtra("places5", places?.get(5))

            startActivity(wheelIntent)
        }

        rvPlaces.adapter = adapter
        rvPlaces.layoutManager = LinearLayoutManager(this)

        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val yelpService = retrofit.create(YelpService::class.java)


        if (dollars == ""){
            yelpService.search2("Bearer $API_KEY", term!!, 10, location!!).enqueue(object : Callback<YelpSearchResult> {


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

        else {
            yelpService.search("Bearer $API_KEY", term!!, 10, dollars!!, location!!)
                .enqueue(object : Callback<YelpSearchResult> {


                    override fun onResponse(
                        call: Call<YelpSearchResult>,
                        response: Response<YelpSearchResult>
                    ) {
                        Log.i(TAG, "onResponse $response")
                        val body = response.body()
                        if (body == null) {
                            Log.w(
                                TAG,
                                "Did not receive valid response body from Yelp API... exiting"
                            )
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



    //Method for when restaurants are clicked sending them to details page
    override fun onItemClick(position: Int) {
        val detailIntent = Intent(this, DetailActivity::class.java)
        val clickedItem : YelpPlaces = places[position]

        val milesPerMeter = 0.000621371
        val distance = "%.2f".format(clickedItem.distanceInMeters * milesPerMeter)

        detailIntent.putExtra("EX_NAME", clickedItem.name)
        detailIntent.putExtra("EX_ADDRESS", clickedItem.location.address)
        detailIntent.putExtra("EX_PRICE", clickedItem.price)
        detailIntent.putExtra("EX_URL", clickedItem.imageUrl)
        detailIntent.putExtra("EX_DISTANCE", distance)
        detailIntent.putExtra("EX_NUMREVIEWS", clickedItem.numReviews)
        detailIntent.putExtra("EX_RATING", clickedItem.rating)
        detailIntent.putExtra("EX_CATEGORIES", clickedItem.categories[0].title)


        startActivity(detailIntent)

    }


    // Method to move between fragments via FragmentManager
    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            val fl = findViewById<View>(R.id.fl_wrapper) as FrameLayout
            fl.removeAllViews()
            val transaction1: FragmentTransaction = supportFragmentManager.beginTransaction()
            transaction1.add(R.id.fl_wrapper, fragment)
            transaction1.commit()
        }




}