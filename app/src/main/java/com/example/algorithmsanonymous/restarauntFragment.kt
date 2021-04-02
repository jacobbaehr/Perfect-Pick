package com.example.algorithmsanonymous

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class restarauntFragment : Fragment() {

    /*
    NOTES:
    As the user moves between destinations defined in the navigation graph,
    the navigation host Fragment swaps fragments in and out as necessary.
    The Fragment also creates and manages the appropriate Fragment back stack.
     */

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaraunt, container, false)
    }



}