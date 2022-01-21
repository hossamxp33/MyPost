package com.tarweej.mypost.repo.authenticate


import com.tarweej.mypost.entites.auth.LoginModel
import retrofit2.Response


/**
Created by Prokash Sarkar on Tue, January 19, 2021
 **/


interface DataSource {

    suspend fun getLoginResponse(username:String,password:String): Response<LoginModel>

//register
//
//    suspend fun getRegisterResponse(registerModel: User): Response<LoginModel>
//
//
//    suspend fun facebookResponse(facebookModel : User): Response<LoginModel>
}