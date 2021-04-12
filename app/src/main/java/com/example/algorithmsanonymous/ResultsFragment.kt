package com.example.algorithmsanonymous

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val TAG = "ResultsFragment"
private const val BASE_URL = "https://api.yelp.com/v3/"
private const val API_KEY = "ByqULIICRmITM2YWyQrSKQdiEIzLk413fhmf1x-LQ7Sm7PiJb_qUv8Az2GzFaZ-Q8tPGRPMGkmxAomXlg0oaNgfEJMa7yDFUUgsQe3rIg1PzmUy_zRCWxhi5EYRPYHYx"


class ResultsFragment() : Fragment() { //, PlacesAdapter.OnItemClickListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        // Transfer to MainActivity2 (API Code to display results)
        this.startActivity(Intent(activity, MainActivity2::class.java))

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_main2, container, false)
    }

//    val thiscontext = container!!.context
//
//    val places = mutableListOf<YelpPlaces>()
//    val adapter = PlacesAdapter(thiscontext, places, this)

//    override fun onCreate(savedInstanceState: Bundle?) {
//
//        super.onCreate(savedInstanceState)
//        //setContentView(R.layout.activity_main2)
//
//        rvPlaces.adapter = adapter
//        rvPlaces.layoutManager = LinearLayoutManager(activity)
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        val yelpService = retrofit.create(YelpService::class.java)
//        yelpService.search("Bearer $API_KEY","Bar", "Lakeland").enqueue(object :
//            Callback<YelpSearchResult> {
//
//
//            override fun onResponse(call: Call<YelpSearchResult>, response: Response<YelpSearchResult>) {
//                Log.i(TAG, "onResponse $response")
//                val body = response.body()
//                if (body == null) {
//                    Log.w(TAG, "Did not receive valid response body from Yelp API... exiting")
//                    return
//                }
//                places.addAll(body.places)
//                adapter.notifyDataSetChanged()
//
//            }
//
//            override fun onFailure(call: Call<YelpSearchResult>, t: Throwable) {
//                Log.i(TAG, "onFailure $t")
//            }
//        })
//
//    }

//    //Method for when restaurants are clicked sending them to details page
//    override fun onItemClick(position: Int) {
//        val detailIntent = Intent(activity, DetailActivity::class.java)
//        val clickedItem : YelpPlaces = places[position]
//
//        val milesPerMeter = 0.000621371
//        val distance = "%.2f".format(clickedItem.distanceInMeters * milesPerMeter)
//
//        detailIntent.putExtra("EX_NAME", clickedItem.name)
//        detailIntent.putExtra("EX_ADDRESS", clickedItem.location.address)
//        detailIntent.putExtra("EX_PRICE", clickedItem.price)
//        detailIntent.putExtra("EX_URL", clickedItem.imageUrl)
//        detailIntent.putExtra("EX_DISTANCE", distance)
//        detailIntent.putExtra("EX_NUMREVIEWS", clickedItem.numReviews)
//        detailIntent.putExtra("EX_RATING", clickedItem.rating)
//        detailIntent.putExtra("EX_CATEGORIES", clickedItem.categories[0].title)
//
//
//        startActivity(detailIntent)
//
//    }

}