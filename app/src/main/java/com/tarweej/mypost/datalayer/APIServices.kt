package com.tarweej.mypost.datalayer

import com.tarweej.mypost.entites.home.MainDataModel
import retrofit2.http.GET


interface APIServices {


    @GET("FamousInfo/homepage.json")
    suspend fun getMainData(): MainDataModel


}