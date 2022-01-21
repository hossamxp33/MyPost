package com.tarweej.mypost.datalayer

import com.tarweej.mypost.entites.auth.LoginModel
import com.tarweej.mypost.entites.famousinfo.FamousInfoModel
import com.tarweej.mypost.entites.home.MainDataModel
import retrofit2.Response
import retrofit2.http.*


interface APIServices {


    @GET("FamousInfo/homepage.json")
    suspend fun getMainData(): MainDataModel

    @FormUrlEncoded
    @POST("FamousInfo/index.json")
    suspend fun getFamousInfo(@Field("Filter[famous_id]") famous_id: Int?,
    ): FamousInfoModel

    ////////////// Authentication
    @FormUrlEncoded
    @POST("users/token.json")
    suspend fun login(
       @Field("username") username: String?,
       @Field("password") password: String?
    ): Response<LoginModel>
}