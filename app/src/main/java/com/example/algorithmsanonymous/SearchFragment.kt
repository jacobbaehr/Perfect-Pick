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


    lateinit var mView: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate current fragment
        mView = inflater.inflate(R.layout.fragment_search, container, false)

        // The way that we're moving through fragments below introduces bugs and doesn't function 100%
        // See commented out code below .. I believe that is how we'll need to implement the swaps

        // Set button listeners and define actions for button press
        mView.RestaurantButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_searchFragment_to_restarauntFragment)
        }
        mView.NightlifeButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_searchFragment_to_nightlifeFragment)
        }
        mView.ActivityButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_searchFragment_to_activityFragment)
        }
        return mView.rootView

    }

}

// -------------------------------------
// May use later -- don't delete (Chris)
// -------------------------------------
//        override fun onCreateView(
//            inflater: LayoutInflater, container: ViewGroup?,
//            savedInstanceState: Bundle?
//        ): View? {
//
//            // Inflate the layout for this fragment
//            return inflater.inflate(R.layout.fragment_search, container, false)
//        }
//        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//            super.onViewCreated(view, savedInstanceState)
//
//            RestaurantButton.setOnClickListener {
//                val fr = fragmentManager?.beginTransaction()
//                fr?.replace(R.id.searchFragment, ActivityFragment())
//                fr?.commit()
//            }
//            NightlifeButton.setOnClickListener {
//                replaceFragment(NightlifeFragment())
//            }
//            ActivityButton.setOnClickListener {
//                replaceFragment(ActivityFragment())
//            }
//        }
//
//    private fun replaceFragment(fragment: Fragment) {
//        val transaction = fragmentManager?.beginTransaction()
//        transaction?.replace(R.id.fl_wrapper, fragment)
//        transaction?.commit()
//    }

// Call API function from MainActivity
// (activity as MainActivity?)!!.searchAPI()

// Moving to a new activity file
//this.startActivity(Intent(activity, MainActivity2::class.java))





