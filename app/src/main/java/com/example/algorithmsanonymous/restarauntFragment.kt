package com.example.algorithmsanonymous

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_restaraunt.*
import kotlinx.android.synthetic.main.fragment_restaraunt.view.*
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search.button
import kotlinx.android.synthetic.main.fragment_search.view.*
import kotlinx.android.synthetic.main.fragment_search.view.button


@Suppress("DEPRECATION")
class restarauntFragment : Fragment() {


//    lateinit var nView: View
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle?): View? {
//
//        // Inflate current fragment
//        nView = inflater.inflate(R.layout.fragment_restaraunt, container, false)
//
//        // Set button listeners and define actions for button press
//        nView.button.setOnClickListener {
//            view?.findNavController()?.navigate(R.id.action_restarauntFragment_to_resultsFragment)
//        }
//        return nView
//    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaraunt, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set button listener, execute action inside if applicable
        button.setOnClickListener {

            // Example of how to make transaction without method call
            val fr = fragmentManager?.beginTransaction()
            fr?.replace(R.id.fl_wrapper, ResultsFragment())
            fr?.commit()
        }
    }


    // Purpose: Swap from one fragment to another (note the use of fl_wrapper from activity_main.xml)
    private fun replaceFragment(fragment: Fragment) {
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.fl_wrapper, fragment)
        transaction?.commit()
    }



}