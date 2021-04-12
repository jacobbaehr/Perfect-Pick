package com.example.algorithmsanonymous


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_restaraunt.*
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search.view.*


@Suppress("DEPRECATION")
class SearchFragment : Fragment() {

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {

            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_search, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

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





