package com.example.algorithmsanonymous

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_favorites.*
import kotlinx.android.synthetic.main.fragment_search.*

class FavoritesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        spin.setOnClickListener {
            // Transfer to MainActivity2 (API Code to display results)
//            this.startActivity(Intent(activity, WheelActivity::class.java))
        }

    }
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        var user: FirebaseUser? = auth.currentUser;
        var uid = user?.uid;
        var databaseRef = FirebaseDatabase.getInstance().getReference()
        databaseRef.child(uid.toString()).child("fav").child("favorites").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(getActivity(), "cancelled", Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (dss in snapshot.getChildren()) {
                        val grab = dss.getValue(String::class.java)
                        Toast.makeText(getActivity(), grab, Toast.LENGTH_SHORT).show()
//                        var user:FirebaseUser?= auth.currentUser;
//                        var uid=user?.uid;
//                        var uidString = uid.toString()
//                        var myRef1: DatabaseReference = database!!.getReference(uidString)
//
//
//                        myRef1.child("fav").child("favorites").child(grab).setValue(grab)
                    }
                } //var grab = dss.getValue(String.class);
//                val post = snapshot.child("Cob & Pen").getValue()


            }
        })
    }
    companion object {
        fun newInstance(): FavoritesFragment = FavoritesFragment()
    }

}
//








//