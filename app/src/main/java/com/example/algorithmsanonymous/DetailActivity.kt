package com.example.algorithmsanonymous

import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_place.view.*


class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val intent = intent

        val url = intent.getStringExtra("EX_URL")
        val name = intent.getStringExtra("EX_NAME")
        val address = intent.getStringExtra("EX_ADDRESS")
        val price = intent.getStringExtra("EX_PRICE")
        val distance = intent.getDoubleExtra("EX_DISTANCE", 0.0)
        val numrev = intent.getIntExtra("EX_NUMREVIEWS", 0)
        val rating = intent.getDoubleExtra("EX_RATING", 0.0)
        //val categories = intent.getStringArrayListExtra("EX_CATEGORIES")

        val imageView2: ImageView = findViewById(R.id.imageView2)
        val tvName2: TextView = findViewById(R.id.tvName2)
        val tvNumReviews2: TextView = findViewById(R.id.tvNumReviews2)
        val tvDistance2: TextView = findViewById(R.id.tvDistance2)
        val tvAddress2: TextView = findViewById(R.id.tvAddress2)
        val ratingBar2: RatingBar = findViewById(R.id.ratingBar2)
        //val tvCategory2: TextView = findViewById(R.id.tvCategory2)


//        Glide.with(this).load(url).apply(
//            RequestOptions().transforms(CenterCrop(), RoundedCorners(20))).into(imageView2.imageView)
        tvName2.text = name
        tvNumReviews2.text = "$numrev Reviews"
        tvDistance2.text = distance.toString()
        tvAddress2.text = address
        ratingBar2.rating = rating.toFloat()
        //tvCategory2.text = categories[0].title



    }
}