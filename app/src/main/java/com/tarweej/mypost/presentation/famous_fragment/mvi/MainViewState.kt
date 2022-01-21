package com.tarweej.mypost.presentation.famous_fragment.mvi

import com.tarweej.mypost.entites.famousinfo.FamousInfo
import com.tarweej.mypost.entites.famousinfo.FamousInfoModel
import com.tarweej.mypost.presentation.homefragment.mvi.UserError


data class MainViewState(
    var famousData: FamousInfoModel?=null,
    var filteredData: ArrayList<FamousInfo> ?=null,
    var famousInfo: FamousInfo ?=null,
    val progress:  Boolean? = true,
    var error: UserError?=null

)