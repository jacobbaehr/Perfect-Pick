package com.example.algorithmsanonymous

import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

import com.bluehomestudio.luckywheel.LuckyWheel;
import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget;
import com.bluehomestudio.luckywheel.WheelItem;

import java.util.ArrayList;
import java.util.List;





class WheelActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wheel)

        val intent = intent

        val places = intent.getStringArrayListExtra("places")

        var lw: LuckyWheel = findViewById(R.id.lwv)

        val wheelItems: MutableList<WheelItem> = ArrayList()

        wheelItems.add(WheelItem(
            Color.LTGRAY,
            BitmapFactory.decodeResource(resources, R.drawable.ic_action_name),
            places?.get(0)))

        wheelItems.add(WheelItem(Color.BLUE,
            BitmapFactory.decodeResource(resources, R.drawable.ic_action_name),
            places?.get(1)))

        wheelItems.add(WheelItem(Color.BLACK,
            BitmapFactory.decodeResource(resources, R.drawable.ic_action_name),
            places?.get(2)))

        wheelItems.add(WheelItem(Color.GRAY,
            BitmapFactory.decodeResource(resources, R.drawable.ic_action_name)
            ,places?.get(3)))

        wheelItems.add(WheelItem(Color.RED,
            BitmapFactory.decodeResource(resources, R.drawable.ic_action_name),
            places?.get(4)))

        wheelItems.add(WheelItem(Color.BLACK,
            BitmapFactory.decodeResource(resources, R.drawable.ic_action_name),
            places?.get(5)))

        lw.addWheelItems(wheelItems)

        var start: Button = findViewById(R.id.start)


        start.setOnClickListener {
            lw.rotateWheelTo((0..5).random())
        }


    }
}