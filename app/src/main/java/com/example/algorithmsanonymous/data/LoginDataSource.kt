package com.example.algorithmsanonymous.data

import android.app.PendingIntent.getActivity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.model.getAdapterName
import com.example.algorithmsanonymous.data.model.LoggedInUser
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource  {

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            lateinit var auth: FirebaseAuth
            auth = FirebaseAuth.getInstance()
            var database: FirebaseDatabase? = FirebaseDatabase.getInstance()
            var user:FirebaseUser?= auth.currentUser;
//            var uid=user?.uid;
            var uid="test";
            var uidString = uid.toString()
//            var myRef1: DatabaseReference = database!!.getReference(uidString)
//            myRef1.child("emailuser").setValue(username)
            val User = LoggedInUser(uidString, "Success")

//            var databaseRef = FirebaseDatabase.getInstance().getReference()
//            databaseRef.child(uid.toString()).child("fav").child("favorites").addValueEventListener(object : ValueEventListener {
//                override fun onCancelled(error: DatabaseError) {
//
//                }
//
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    if (snapshot.exists()) {
//                        for (dss in snapshot.getChildren()) {
//                            val grab = dss.getValue(String::class.java)
//                            Toast.makeText(getActivity(), grab, Toast.LENGTH_SHORT).show()
//                            val User1 = LoggedInUser(uidString, user?.email.toString())
//                            Result.Success(User1)
//
////                        var user:FirebaseUser?= auth.currentUser;
////                        var uid=user?.uid;
////                        var uidString = uid.toString()
////                        var myRef1: DatabaseReference = database!!.getReference(uidString)
////
////
////                        myRef1.child("fav").child("favorites").child(grab).setValue(grab)
//                        }
//                    } //var grab = dss.getValue(String.class);
////                val post = snapshot.child("Cob & Pen").getValue()
//
//
//                }
//            })

            return Result.Success(User)

        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}
