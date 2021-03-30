package com.example.algorithmsanonymous.ui.login


import android.R.attr
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.algorithmsanonymous.MainActivity
import com.example.algorithmsanonymous.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.IgnoreExtraProperties
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity: AppCompatActivity() {



    lateinit var inputEmail: EditText
    lateinit var inputPassword: EditText
    lateinit var btnSignIn: Button
    lateinit var btnSignUp: Button
    lateinit var btnResetPassword: Button
    lateinit var progressBar: ProgressBar
    lateinit var auth: FirebaseAuth


    var database: FirebaseDatabase? = FirebaseDatabase.getInstance()



    private lateinit var loginViewModel: LoginViewModel
    private var mAuth: FirebaseAuth? = null

    // Write a message to the database



     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_login)


        auth = FirebaseAuth.getInstance()



        //setContentView(R.layout.activity_main)

        btnSignIn = findViewById<Button>(R.id.login)
        btnSignUp = findViewById<Button>(R.id.login)
        inputEmail = findViewById<EditText>(R.id.username)
        inputPassword = findViewById<EditText>(R.id.username)




        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val login = findViewById<Button>(R.id.login)
        val loading = findViewById<ProgressBar>(R.id.loading)



        loginViewModel = ViewModelProvider(this, LoginViewModelFactory())
                .get(LoginViewModel::class.java)

        loginViewModel.loginFormState.observe(this@LoginActivity, Observer {
            val loginState = it ?: return@Observer

            // disable login button unless both username / password is valid
            login.isEnabled = loginState.isDataValid

            if (loginState.usernameError != null) {
                username.error = getString(loginState.usernameError)
            }
            if (loginState.passwordError != null) {
                password.error = getString(loginState.passwordError)
            }
        })

        loginViewModel.loginResult.observe(this@LoginActivity, Observer {
            val loginResult = it ?: return@Observer

            loading.visibility = View.GONE
            if (loginResult.error != null) {
                showLoginFailed(loginResult.error)
            }
            if (loginResult.success != null) {
                updateUiWithUser(loginResult.success)
            }
            setResult(Activity.RESULT_OK)


            //Complete and destroy login activity once successful
            finish()
        })

        username.afterTextChanged {
            loginViewModel.loginDataChanged(
                    username.text.toString(),
                    password.text.toString()
            )
        }

        password.apply {
            afterTextChanged {
                loginViewModel.loginDataChanged(
                        username.text.toString(),
                        password.text.toString()
                )
            }

            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        loginViewModel.login(
                                username.text.toString(),
                                password.text.toString()
                        )
                }
                false
            }

            login.setOnClickListener {

                loading.visibility = View.VISIBLE
                loginViewModel.login(username.text.toString(), password.text.toString())

                val email1 = inputEmail.text.toString().trim { it <= ' ' }
                val password = inputPassword.text.toString().trim { it <= ' ' }

                if (TextUtils.isEmpty(email1)) {
                    Toast.makeText(
                        applicationContext,
                        "Enter email address!",
                        Toast.LENGTH_SHORT
                    ).show()

                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(applicationContext, "Enter password!", Toast.LENGTH_SHORT)
                        .show()

                }

                if (password.length < 6) {
                    Toast.makeText(
                        applicationContext,
                        "Password too short, enter minimum 6 characters!",
                        Toast.LENGTH_SHORT
                    ).show()

                }

                auth.createUserWithEmailAndPassword(email1, password)
                    .addOnCompleteListener(

                        this@LoginActivity,
                        OnCompleteListener<AuthResult?> { task ->
                            Toast.makeText(
                                this@LoginActivity,
                                "createUserWithEmail:onComplete:" + task.isSuccessful,
                                Toast.LENGTH_SHORT
                            ).show()

                            // If sign in fails, display a message to the user. If sign in succeeds
                            // the auth state listener will be notified and logic to handle the
                            // signed in user can be handled in the listener.
                            if (!task.isSuccessful) {
                                Toast.makeText(
                                    this@LoginActivity,
                                    "Authentication passed." + task.isSuccessful,
                                    Toast.LENGTH_SHORT
                                ).show()
                                auth.signInWithEmailAndPassword(email1, password)
                                        .addOnCompleteListener(this@LoginActivity) { task ->
                                            // If sign in fails, display a message to the user. If sign in succeeds
                                            // the auth state listener will be notified and logic to handle the
                                            // signed in user can be handled in the listener.
                                            progressBar.visibility = View.GONE
                                            if (!task.isSuccessful) {
                                                // there was an error
                                                if (password.length < 6) {

                                                } else {
//                                                    Toast.makeText(this@LoginActivity, getString(R.string.auth_failed), Toast.LENGTH_LONG).show()
                                                }
                                            } else {
                                                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                                                startActivity(intent)
                                                finish()
                                            }
                                        }
                            } else {


                            }

                        })
                writeNewUser("1", username.toString(), email1)

            }

        }
    }

    private fun updateUiWithUser(model: LoggedInUserView) {
        val welcome = getString(R.string.welcome)
        val displayName = model.displayName

        Toast.makeText(
                applicationContext,
                "$welcome $displayName",
                Toast.LENGTH_LONG
        ).show()

        // CHRIS-LINDSEY: This is where we switch from the login page to the main activity file/page
        startActivity (
                Intent(this,
                        MainActivity::class.java
                ))
    }
    private fun updateUiWithUser(model: FirebaseUser?) {
        val welcome = getString(R.string.welcome)
        val displayName = model?.displayName

        Toast.makeText(
                applicationContext,
                "$welcome $displayName",
                Toast.LENGTH_LONG
        ).show()

        // CHRIS-LINDSEY: This is where we switch from the login page to the main activity file/page
        startActivity (
                Intent(this,
                        MainActivity::class.java
                ))
    }


    private fun createAccount(email: String, password: String, name: String, mobile: String) {

        mAuth!!.createUserWithEmailAndPassword(email, attr.password.toString())
                .addOnCompleteListener(this) { task ->


                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information

                        val user = mAuth!!.currentUser
                        updateUiWithUser(user)
                    }

                    // ...
                }

    }

    fun writeNewUser(userId: String, name: String, email: String) {

        var myRef1: DatabaseReference = database!!.getReference("message")
        var myRef2: DatabaseReference = database!!.getReference("message")
        var myRef3: DatabaseReference = database!!.getReference("message")
        var myRef4: DatabaseReference = database!!.getReference("message")
        var myRef5: DatabaseReference = database!!.getReference("message")
        var post1 = myRef1.child("friends").child("email").child(userId).setValue(email)
        var post2 = myRef2.child("friends").child("friend2").child(userId).setValue("Jimo")
        var post3 = myRef3.child("friends").child("friend3").child(userId).setValue("Jim")
        var post4 = myRef4.child("friends").child("friend4").child(userId).setValue("Jimtron")
        var post5 = myRef5.child("friends").child("friend1").child(userId).setValue("Jimtron7")
    }
    fun writeNewUserWithTaskListeners(userId: String, name: String, email: String, myRef1:DatabaseReference, myRef2:DatabaseReference, myRef3:DatabaseReference, myRef4:DatabaseReference) {
        val user = User(name, email)

        // [START rtdb_write_new_user_task]
        myRef1.child("users").child(userId).setValue(user)
            .addOnSuccessListener {
                // Write was successful!
                // ...
            }
            .addOnFailureListener {
                // Write failed
                // ...
            }
        // [END rtdb_write_new_user_task]
        // [START rtdb_write_new_user_task]
        myRef2.child("users").child(userId).setValue(user)
            .addOnSuccessListener {
                // Write was successful!
                // ...
            }
            .addOnFailureListener {
                // Write failed
                // ...
            }
        // [END rtdb_write_new_user_task]
        // [START rtdb_write_new_user_task]
        myRef3.child("users").child(userId).setValue(user)
            .addOnSuccessListener {
                // Write was successful!
                // ...
            }
            .addOnFailureListener {
                // Write failed
                // ...
            }
        // [END rtdb_write_new_user_task]
        // [START rtdb_write_new_user_task]
        myRef4.child("users").child(userId).setValue(user)
            .addOnSuccessListener {
                // Write was successful!
                // ...
            }
            .addOnFailureListener {
                // Write failed
                // ...
            }
        // [END rtdb_write_new_user_task]

    }
    private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }

}

/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}
@IgnoreExtraProperties
data class User(val username: String? = null, val email: String? = null) {
    // Null default values create a no-argument default constructor, which is needed
    // for deserialization from a DataSnapshot.
}