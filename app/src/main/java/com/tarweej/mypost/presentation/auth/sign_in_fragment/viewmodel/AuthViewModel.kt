package com.tarweej.mypost.presentation.auth.sign_in_fragment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tarweej.mypost.entites.auth.LoginModel
import com.tarweej.mypost.helper.PreferenceHelper

import com.tarweej.mypost.repo.authenticate.RemoteDataSource
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.*
import javax.inject.Inject

class AuthViewModel @Inject constructor(private val Datasources: RemoteDataSource,
) : ViewModel() {

    @Inject
    lateinit var Pref: PreferenceHelper
    private var job: Job? = null
    var mCompositeDisposable = CompositeDisposable()

    var authLD: MutableLiveData<LoginModel>? = null

    var errorMessage= MutableLiveData<String>()

    val loading = MutableLiveData<Boolean>()


    init {
        authLD = MutableLiveData()
        errorMessage= MutableLiveData()
    }


    //authentication
//    fun facebookLogin(facebookModel: User?) {
//        job = CoroutineScope(Dispatchers.IO).launch {
//            val response = Datasources.facebookResponse(facebookModel!!)
//            withContext(Dispatchers.Main) {
//                if (response.isSuccessful) {
//                    authLD?.postValue(response.body())
//
//                } else {
//                    onError("Error : ${response.message()} ")
//                }
//            }
//        }
//
//    }
    //authentication
    fun login(username:String,password:String) {
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = Datasources.getLoginResponse(username,password)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    authLD?.postValue(response.body())
                    }
                else {
                     onError("Error : ${response.message()} ")
                }
        }

    }}




    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        mCompositeDisposable.dispose()
        mCompositeDisposable.clear()
    }
}