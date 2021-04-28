package com.example.algorithmsanonymous

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_profile, container, false)

    companion object {
        fun newInstance(): ProfileFragment = ProfileFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activityex = activity as AppCompatActivity?

        activityex!!.getSupportActionBar()!!.setDisplayShowHomeEnabled(true);
        activityex!!.getSupportActionBar()!!.setLogo(R.drawable.logo);
        activityex!!.getSupportActionBar()!!.setDisplayUseLogoEnabled(true);

    }
}
