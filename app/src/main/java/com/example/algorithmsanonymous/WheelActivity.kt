package com.example.algorithmsanonymous

import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.bluehomestudio.luckywheel.LuckyWheel
import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget
import com.bluehomestudio.luckywheel.WheelItem
import com.squareup.picasso.Picasso
import java.io.InputStream
import java.net.URL

import java.util.ArrayList
import java.util.List


class WheelActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wheel)

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.drawable.logo)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        val intent = intent


        // get places
        val place1 = intent.getStringExtra("places1")
        val place2 = intent.getStringExtra("places2")
        val place3 = intent.getStringExtra("places3")
        val place4 = intent.getStringExtra("places4")
        val place5 = intent.getStringExtra("places5")
        val place6 = intent.getStringExtra("places6")

        //val places = intent.getStringArrayListExtra("places")

//        // get place images
//        val place1imgurl = intent.getStringExtra("places1imgurl")
//        val place2imgurl = intent.getStringExtra("places2imgurl")
//        val place3imgurl = intent.getStringExtra("places3imgurl")
//        val place4imgurl = intent.getStringExtra("places4imgurl")
//        val place5imgurl = intent.getStringExtra("places5imgurl")
//        val place6imgurl = intent.getStringExtra("places6imgurl")

        val places = ArrayList<String>()//Creating an empty arraylist
        places.add(place1!!)
        places.add(place2!!)
        places.add(place3!!)
        places.add(place4!!)
        places.add(place5!!)
        places.add(place6!!)

//        Picasso.get().load(place1imgurl).resize(420, 250).centerCrop().into(imageView1)
//        Picasso.get().load(place2imgurl).resize(420, 250).centerCrop().into(imageView2)
//        Picasso.get().load(place3imgurl).resize(420, 250).centerCrop().into(imageView3)
//        Picasso.get().load(place4imgurl).resize(420, 250).centerCrop().into(imageView4)
//        Picasso.get().load(place5imgurl).resize(420, 250).centerCrop().into(imageView5)
//        Picasso.get().load(place6imgurl).resize(420, 250).centerCrop().into(imageView6)
//
//        var place1img = imageView1.drawable
//        var place2img = imageView2.drawable
//        var place3img = imageView3.drawable
//        var place4img = imageView4.drawable
//        var place5img = imageView5.drawable
//        var place6img = imageView6.drawable

//        val place1url: InputStream = URL(place1imgurl).content as InputStream
//        val place2url: InputStream = URL(place2imgurl).content as InputStream
//        val place3url: InputStream = URL(place3imgurl).content as InputStream
//        val place4url: InputStream = URL(place4imgurl).content as InputStream
//        val place5url: InputStream = URL(place5imgurl).content as InputStream
//        val place6url: InputStream = URL(place6imgurl).content as InputStream




        var lw: LuckyWheel = findViewById(R.id.lwv)

        val wheelItems: MutableList<WheelItem> = ArrayList()

        wheelItems.add(WheelItem(Color.parseColor("#00c4cc"),
            BitmapFactory.decodeResource(resources, R.drawable.xs),
            place1))

        wheelItems.add(WheelItem(Color.parseColor("#004c4f"),
            BitmapFactory.decodeResource(resources, R.drawable.xs),
            place2))

        wheelItems.add(WheelItem(Color.parseColor("#00c4cc"),
            BitmapFactory.decodeResource(resources, R.drawable.xs),
            place3))

        wheelItems.add(WheelItem(Color.parseColor("#004c4f"),
            BitmapFactory.decodeResource(resources, R.drawable.xs)
            ,place4))

        wheelItems.add(WheelItem(Color.parseColor("#00c4cc"),
            BitmapFactory.decodeResource(resources, R.drawable.xs),
            place5))

        wheelItems.add(WheelItem(Color.parseColor("#004c4f"),
            BitmapFactory.decodeResource(resources, R.drawable.xs)
            ,place6))

//        wheelItems.add(WheelItem(Color.BLACK,
//            BitmapFactory.decodeResource(resources, R.drawable.ic_action_name),
//            places?.get(5)))

        lw.addWheelItems(wheelItems)

        var start: Button = findViewById(R.id.start)


        start.setOnClickListener {
            val index = (0..5).random()
            lw.rotateWheelTo(index+1)
            lw.setLuckyWheelReachTheTarget {
                Toast.makeText(applicationContext, places.get(index), Toast.LENGTH_LONG).show()
            }
        }


    }
}