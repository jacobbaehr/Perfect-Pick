package com.example.algorithmsanonymous


import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_search.*

@Suppress("DEPRECATION")
class SearchFragment : Fragment() {

        private lateinit var imgAnimation: AnimationDrawable

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {

            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_search, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val activityex = activity as AppCompatActivity?

            activityex!!.getSupportActionBar()!!.setDisplayShowHomeEnabled(true);
            activityex!!.getSupportActionBar()!!.setLogo(R.drawable.logo);
            activityex!!.getSupportActionBar()!!.setDisplayUseLogoEnabled(true);

            val ss = view.findViewById<ImageView>(R.id.imageSlideshow).apply {
                setBackgroundResource(R.drawable.slideshow)
                imgAnimation = background as AnimationDrawable
            }

            imgAnimation.start()


            // Set button listener, execute action inside if applicable
            RestaurantButton.setOnClickListener {
                // Example of how to make transaction without method call
                val fr = fragmentManager?.beginTransaction()
                fr?.replace(R.id.fl_wrapper, restarauntFragment())
                fr?.commit()
            }
            // Set button listener, execute action inside if applicable
            NightlifeButton.setOnClickListener {
                // switching between fragments with method
                replaceFragment(nightlifeFragment())
            }
            // Set button listener, execute action inside if applicable
            ActivityButton.setOnClickListener {
                replaceFragment(activityFragment())
            }
        }


    // Purpose: Swap from one fragment to another (note the use of fl_wrapper from activity_main.xml)
    private fun replaceFragment(fragment: Fragment) {
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.fl_wrapper, fragment)
        transaction?.commit()
    }

}

// Call API function from MainActivity
// (activity as MainActivity?)!!.searchAPI()

// Moving to a new activity file
//this.startActivity(Intent(activity, MainActivity2::class.java))





