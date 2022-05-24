package com.tarweej.mypost

import com.example.dagger.di.scopes.ActivityScope
import com.tarweej.mypost.di.MainModule
import com.tarweej.mypost.helper.FragmentFactoryModule
import com.tarweej.mypost.mainactivity.MainActivity
import com.tarweej.mypost.presentation.auth.AuthenticationActivity
import com.tarweej.mypost.presentation.famous.auth.FamousAuthenticationActivity
import com.tarweej.mypost.presentation.loginas.LoginAsActivity
import com.tarweej.mypost.presentation.settings_activity.SettingsActivity

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

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class, FragmentFactoryModule::class])
    fun contributeAuthenticationActivity(): AuthenticationActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class, FragmentFactoryModule::class])
    fun contributeSettingsActivity(): SettingsActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class, FragmentFactoryModule::class])
    fun contributeLoginAsActivity(): LoginAsActivity
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class, FragmentFactoryModule::class])
    fun FamousAuthenticationActivity(): FamousAuthenticationActivity




}