package com.tarweej.mypost.repo.authenticate



import com.tarweej.mypost.datalayer.APIServices
import com.tarweej.mypost.entites.auth.LoginModel
import retrofit2.Response
import javax.inject.Inject

/**
Created by Prokash Sarkar on Tue, January 19, 2021
 **/

class RemoteDataSource @Inject constructor(private val ApiService: APIServices)
    : DataSource {



    override suspend fun getLoginResponse(username:String,password:String): Response<LoginModel> {
       return ApiService.login(username,password)
    }

//    override suspend fun getRegisterResponse(registerModel: User): Response<LoginModel> {
//        return ApiService.register(registerModel)
//    }
//
//    override suspend fun facebookResponse(facebookModel: User): Response<LoginModel> {
//        return  ApiService.faceBookLogin(facebookModel)
//    }


}