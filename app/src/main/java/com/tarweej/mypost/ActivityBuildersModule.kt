package com.tarweej.mypost

import com.example.dagger.di.scopes.ActivityScope
import com.tarweej.mypost.di.MainModule
import com.tarweej.mypost.helper.FragmentFactoryModule
import com.tarweej.mypost.mainactivity.MainActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
Created by Prokash Sarkar on Tue, January 19, 2021
 **/

@Module
interface ActivityBuildersModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class, FragmentFactoryModule::class])
    fun contributeMainActivity(): MainActivity




}