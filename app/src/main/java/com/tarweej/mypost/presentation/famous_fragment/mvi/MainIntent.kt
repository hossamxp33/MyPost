package com.tarweej.mypost.presentation.famous_fragment.mvi

import com.tarweej.mypost.entites.famousinfo.FamousInfoModel


sealed class MainIntent(open val viewState: MainViewState? = null,open val famousId:Int?=null) {

    data class Initialize(override val viewState: MainViewState, override val famousId: Int?) : MainIntent()

    data class ErrorDisplayed(override val viewState: MainViewState) : MainIntent()

    data  class SearchByName(override val viewState: MainViewState?, val Name:String? = null): MainIntent()

}
