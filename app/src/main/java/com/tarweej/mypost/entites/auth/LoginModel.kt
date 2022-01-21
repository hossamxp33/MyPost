package com.tarweej.mypost.entites.auth

import com.tarweej.mypost.entites.User

data class LoginModel(
    var data : User?=null,
    var message: String ?=null,
    var success: Boolean?=null
)