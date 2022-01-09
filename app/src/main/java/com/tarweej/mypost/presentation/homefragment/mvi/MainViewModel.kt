package com.tarweej.mypost.presentation.homefragment.mvi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tarweej.mypost.BaseViewModel
import com.tarweej.mypost.repo.homepage.DataRepo
import com.tarweej.mypost.repo.homepage.DataSource

import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel @Inject constructor(private val Datasources: DataSource,
                                        private val DateRepoCompnay: DataRepo,



                                        )
    : BaseViewModel<MainViewState>() {

    val intents : Channel<MainIntent> = Channel<MainIntent>(Channel.UNLIMITED)

    protected val uiState : MutableStateFlow<MainViewState?> = MutableStateFlow(MainViewState())

    val state: MutableStateFlow<MainViewState?> get() = uiState

    private var job: Job? = null
     private val viewStateMapper: suspend (MainIntent) -> MainViewState = { mapIntentToViewState(it,DateRepoCompnay) }



    val errorMessage = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()


    init {


        getIntent()

// لازم ابعت viewstate كامل واتحكم بكل option حسب المطلوب وارساله مرة اخري واستقباله هنا او في ال view

uiState.value = MainViewState().copy(progress = true)
   // launchNextViewStateJob(intents.value)
}

fun getIntent(){

    job = viewModelScope.launch() {

        intents.receiveAsFlow().collect {

            uiState.value = (viewStateMapper(it))

        }
    }
}





    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }
    override fun onCleared() {
        super.onCleared()
        job!!.cancel()
    }



}




