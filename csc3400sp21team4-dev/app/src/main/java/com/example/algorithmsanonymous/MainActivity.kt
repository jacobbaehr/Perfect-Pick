package com.example.algorithmsanonymous

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val TAG = "MainActivity"
private const val BASE_URL = "https://api.yelp.com/v3/"
private const val API_KEY = "ByqULIICRmITM2YWyQrSKQdiEIzLk413fhmf1x-LQ7Sm7PiJb_qUv8Az2GzFaZ-Q8tPGRPMGkmxAomXlg0oaNgfEJMa7yDFUUgsQe3rIg1PzmUy_zRCWxhi5EYRPYHYx"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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