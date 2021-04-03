package com.example.algorithmsanonymous


import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.*
import kotlinx.android.synthetic.main.fragment_search.view.*


@Suppress("DEPRECATION")
class SearchFragment : Fragment() {

    lateinit var mView: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate current fragment
        mView = inflater.inflate(R.layout.fragment_search, container, false)

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
        return mView
    }
    
}

// -------------------------------------
// May use later -- don't delete (Chris)
// -------------------------------------
// Call API function from MainActivity
// (activity as MainActivity?)!!.searchAPI()

// Moving to a new activity file
//this.startActivity(Intent(activity, MainActivity2::class.java))


// Attempted to use this code as a means of managing fragment switching
// Kept getting errors because of the "<FragmentTitleBinding>"

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
//                R.layout.fragment_search,container,false)
//
//        binding.playButton.setOnClickListener { view : View ->
//            view.findNavController().navigate(R.id.action_searchFragment_to_restarauntFragment)
//        }
//        setHasOptionsMenu(true)
//        return binding.root
//    }
//
//}




