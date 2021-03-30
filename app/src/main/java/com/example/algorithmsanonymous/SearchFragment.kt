package com.example.algorithmsanonymous

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class SearchFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_search, container, false)


    companion object {
        fun newInstance(): SearchFragment = SearchFragment()
    }


    // ------------------------------------------------------
    // IMPLEMENTATION THOUGHTS BELOW - UNSURE OF PRACTICALITY
    // ------------------------------------------------------

    // BUTTON FUNCTIONALITY SHOULD GO HERE -- IF CLICKED, RUN FUNCTION (PASSING NEEDED PARAMETERS THROUGH)


    // API SEARCH FUNCTION HERE, USING INPUT FROM TEXT IN FRAGMENT_SEARCH.XML



}