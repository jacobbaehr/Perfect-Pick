package com.example.algorithmsanonymous

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_restaraunt.view.*
import kotlinx.android.synthetic.main.fragment_search.view.*
import kotlinx.android.synthetic.main.fragment_search.view.button


class restarauntFragment : Fragment() {


    lateinit var nView: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate current fragment
        nView = inflater.inflate(R.layout.fragment_restaraunt, container, false)

        // Set button listeners and define actions for button press
        nView.button.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_restarauntFragment_to_resultsFragment)
        }
        return nView
    }



}