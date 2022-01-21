package com.tarweej.mypost.repo.homepage


import com.tarweej.mypost.entites.famousinfo.FamousInfoModel
import com.tarweej.mypost.entites.home.MainDataModel


interface DataSource {

    suspend fun getMainResponse(): MainDataModel

    suspend fun getFamousInfoResponse(famous_id : Int?): FamousInfoModel


}