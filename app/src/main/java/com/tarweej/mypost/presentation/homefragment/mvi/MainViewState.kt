package com.tarweej.mypost.presentation.homefragment.mvi

import com.tarweej.mypost.entites.home.MainDataModel


data class MainViewState(
    var homepagedata: MainDataModel?=null,
    val progress:  Boolean? = null,
    var error:UserError?=null

)