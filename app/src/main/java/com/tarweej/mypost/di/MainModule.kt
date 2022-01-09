package com.tarweej.mypost.di

import androidx.lifecycle.ViewModel
import com.tarweej.mypost.helper.ViewModelKey
import com.tarweej.mypost.presentation.homefragment.mvi.MainViewModel


import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap



@Module
interface MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel



}