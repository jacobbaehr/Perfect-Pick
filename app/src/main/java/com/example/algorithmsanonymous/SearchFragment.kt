package com.example.algorithmsanonymous


import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_search.view.*


@Suppress("DEPRECATION")
class SearchFragment : Fragment() {

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle?): View? {
//        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
//                R.layout.fragment_search,container,false)
//        return binding.root
//    }
//}

    lateinit var mView: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
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
//(activity as MainActivity?)!!.searchAPI()

// Call API function from MainActivity
//this.startActivity(Intent(activity, MainActivity2::class.java))




