package com.tarweej.mypost.repo.homepage


import com.tarweej.mypost.entites.home.MainDataModel


interface DataSource {

    suspend fun getMainResponse(): MainDataModel



}