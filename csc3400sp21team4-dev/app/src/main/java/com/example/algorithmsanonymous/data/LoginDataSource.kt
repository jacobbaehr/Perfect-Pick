package com.example.algorithmsanonymous.data

import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.algorithmsanonymous.R
import com.example.algorithmsanonymous.data.model.LoggedInUser
import com.example.algorithmsanonymous.ui.login.LoginActivity
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            // TODO: handle loggedInUser authentication
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), username)
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}