package com.example.algorithmsanonymous

import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

import com.bluehomestudio.luckywheel.LuckyWheel
import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget
import com.bluehomestudio.luckywheel.WheelItem

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

        val place1 = intent.getStringExtra("places1")
        val place2 = intent.getStringExtra("places2")
        val place3 = intent.getStringExtra("places3")
        val place4 = intent.getStringExtra("places4")
        val place5 = intent.getStringExtra("places5")
        val place6 = intent.getStringExtra("places6")

        //val places = intent.getStringArrayListExtra("places")

        var lw: LuckyWheel = findViewById(R.id.lwv)

        val wheelItems: MutableList<WheelItem> = ArrayList()

        wheelItems.add(WheelItem(Color.parseColor("#00c4cc"),
            BitmapFactory.decodeResource(resources, R.drawable.ic_action_name),
            place1))

        wheelItems.add(WheelItem(Color.parseColor("#004c4f"),
            BitmapFactory.decodeResource(resources, R.drawable.ic_action_name),
            place2))

        wheelItems.add(WheelItem(Color.parseColor("#00c4cc"),
            BitmapFactory.decodeResource(resources, R.drawable.ic_action_name),
            place3))

        wheelItems.add(WheelItem(Color.parseColor("#004c4f"),
            BitmapFactory.decodeResource(resources, R.drawable.ic_action_name)
            ,place4))

        wheelItems.add(WheelItem(Color.parseColor("#00c4cc"),
            BitmapFactory.decodeResource(resources, R.drawable.ic_action_name),
            place5))

        wheelItems.add(WheelItem(Color.parseColor("#004c4f"),
            BitmapFactory.decodeResource(resources, R.drawable.ic_action_name)
            ,place6))

//        wheelItems.add(WheelItem(Color.BLACK,
//            BitmapFactory.decodeResource(resources, R.drawable.ic_action_name),
//            places?.get(5)))

        lw.addWheelItems(wheelItems)

        var start: Button = findViewById(R.id.start)


        start.setOnClickListener {
            lw.rotateWheelTo((0..6).random())
        }


    }
}