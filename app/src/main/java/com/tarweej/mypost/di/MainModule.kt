package com.tarweej.mypost.di

import androidx.lifecycle.ViewModel
import com.tarweej.mypost.helper.ViewModelKey
import com.tarweej.mypost.presentation.auth.sign_in_fragment.viewmodel.AuthViewModel
import com.tarweej.mypost.presentation.homefragment.mvi.MainViewModel
import com.tarweej.mypost.presentation.famous_fragment.mvi.FamousViewModel


import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap



@Module
interface MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    fun AuthViewModel(AuthViewModel: AuthViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(FamousViewModel::class)
    fun famousViewModel(FamousViewModel: FamousViewModel): ViewModel



}