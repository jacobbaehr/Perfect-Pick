package com.example.algorithmsanonymous.ui.login

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class UserInfo(
    var name: String? = "",
    var mobile: String? = ""

)
