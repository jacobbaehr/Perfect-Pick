package com.example.algorithmsanonymous

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Create "listener" for favorites switch
        favorite2.setOnCheckedChangeListener { _, isChecked ->

            // do whatever you need to do when the switch is toggled
            setContentView(R.layout.activity_main)
        }

        val intent = intent

        val url = intent.getStringExtra("EX_URL")
        val name = intent.getStringExtra("EX_NAME")
        val address = intent.getStringExtra("EX_ADDRESS")
        val price = intent.getStringExtra("EX_PRICE")
        val distance = intent.getStringExtra("EX_DISTANCE")
        val numrev = intent.getIntExtra("EX_NUMREVIEWS", 0)
        val rating = intent.getDoubleExtra("EX_RATING", 0.0)
        val categories = intent.getStringExtra("EX_CATEGORIES")

        val imageView2: ImageView = findViewById(R.id.imageView2)
        val tvName2: TextView = findViewById(R.id.tvName2)
        val tvNumReviews2: TextView = findViewById(R.id.tvNumReviews2)
        val tvDistance2: TextView = findViewById(R.id.tvDistance2)
        val tvAddress2: TextView = findViewById(R.id.tvAddress2)
        val ratingBar2: RatingBar = findViewById(R.id.ratingBar2)
        val tvCategory2: TextView = findViewById(R.id.tvCategory2)
        val mapView2: ImageView = findViewById(R.id.mapView2)

        //temporary map val
        val url2 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXFT9i-PYv2LqpQaF3asNIWKjKnGWA8BDa9w&usqp=CAU"

        Picasso.get().load(url).resize(420, 250).centerCrop().into(imageView2);
        tvName2.text = name
        tvNumReviews2.text = "$numrev Reviews"
        tvDistance2.text = "$distance Miles"
        tvAddress2.text = "$address -"
        ratingBar2.rating = rating.toFloat()
        tvCategory2.text = categories
        Picasso.get().load(url2).resize(410, 250).centerCrop().into(mapView2);


    }


}