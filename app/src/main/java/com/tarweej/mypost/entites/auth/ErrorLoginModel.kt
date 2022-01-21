package com.tarweej.mypost.entites.auth

data class ErrorLoginModel(
    var code: Int?,
    var message: String?,
    var url: String?
)