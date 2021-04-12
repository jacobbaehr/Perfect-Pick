package com.example.algorithmsanonymous

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.fragment_restaraunt.*
import kotlinx.android.synthetic.main.fragment_search.button


@Suppress("DEPRECATION")
class nightlifeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nightlife, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        chipGroup.forEach { child ->
            (child as? Chip)?.setOnCheckedChangeListener { _, _ ->
                registerFilterChanged()
            }
        }

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


    // Get $ for restaurant
    private fun registerFilterChanged() {
        val ids = chipGroup.checkedChipIds

        val titles = mutableListOf<CharSequence>()

        ids.forEach { id ->
            titles.add(chipGroup.findViewById<Chip>(id).text)
        }

        val text = if (titles.isNotEmpty()) {
            titles.joinToString(", ")
        } else {
            "No Choice"
        }

        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
    }



}