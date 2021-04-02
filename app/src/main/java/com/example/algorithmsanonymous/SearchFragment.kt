package com.example.algorithmsanonymous

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_search.view.*


class SearchFragment : Fragment() {

    lateinit var mView: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mView=inflater.inflate(R.layout.fragment_search,container,false)

        // Set button listener, use lateinit var located under class declaration
        mView.RestaurantButton.setOnClickListener {


            // -------------------------------------
            // May use later -- don't delete (Chris)
            // -------------------------------------
            // Call API function from MainActivity
            //(activity as MainActivity?)!!.searchAPI()

            this.startActivity(Intent (activity,MainActivity2::class.java))


        }
        // Return the created view above as a result of button click
        return mView
    }


    companion object {
        fun newInstance(): SearchFragment = SearchFragment()
    }


}


