package com.example.algorithmsanonymous

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.fragment_restaraunt.*
import kotlinx.android.synthetic.main.fragment_search.button


@Suppress("DEPRECATION")
class activityFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val inputSpecify = requireView().findViewById<EditText>(R.id.activityType)
        val inputZip = requireView().findViewById<EditText>(R.id.zipCode)

        chipGroup.forEach { child ->
            (child as? Chip)?.setOnCheckedChangeListener { _, _ ->
                registerFilterChanged()
            }
        }


        // Set button listener, execute action inside if applicable
        button.setOnClickListener {

            val sendInput = inputSpecify.text.toString()
            val sendZip = inputZip.text.toString()
            val sendDollar = registerFilterChanged()

            if (sendInput.isEmpty() || sendZip.isEmpty()) {
                if (sendInput.isEmpty()) {
                    inputSpecify.error = "Please enter activity specifications."
                }
                else {
                    inputZip.error = "Please enter zip code."
                }
            }

            else {
                val i = Intent(activity, MainActivity2::class.java)

                i.putExtra("INPUT_1", sendInput)
                i.putExtra("INPUT_2", sendZip)
                i.putExtra("INPUT_3", sendDollar)

                // Transfer to MainActivity2 (API Code to display results)
                this.startActivity(i)

                //keeping for later reference this is how fragment data is passed
    //            val bundle = Bundle()
    //            bundle.putString("INPUT1", sendInput)
    //            val fragobj = ResultsFragment()
    //            fragobj.arguments = bundle

                // Example of how to make transaction without method call  - THIS GOES TO RESULTS
    //            val fr = fragmentManager?.beginTransaction()
    //            fr?.replace(R.id.fl_wrapper, ResultsFragment())
    //            fr?.commit()
            }
        }
    }


    // Purpose: Swap from one fragment to another (note the use of fl_wrapper from activity_main.xml)
    private fun replaceFragment(fragment: Fragment) {
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.fl_wrapper, fragment)
        transaction?.commit()
    }


    // Get $ for restaurant
    private fun registerFilterChanged(): String {
        val ids = chipGroup.checkedChipIds

        val titles = mutableListOf<CharSequence>()

        ids.forEach { id ->
            if (chipGroup.findViewById<Chip>(id).text == "$") {
                titles.add("1")
            }
            if (chipGroup.findViewById<Chip>(id).text == "$$") {
                titles.add("2")
            }
            if (chipGroup.findViewById<Chip>(id).text == "$$$") {
                titles.add("3")
            }
            if (chipGroup.findViewById<Chip>(id).text == "$$$$") {
                titles.add("4")
            }

            //titles.add(chipGroup.findViewById<Chip>(id).text)
        }

        val text = if (titles.isNotEmpty()) {
            titles.joinToString(", ")
        } else {
            ""
        }

        return text
        //Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
    }



}