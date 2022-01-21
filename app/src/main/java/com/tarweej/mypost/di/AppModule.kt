package com.tarweej.mypost.di



import android.content.Context
import com.tarweej.mypost.datalayer.APIServices
import com.tarweej.mypost.helper.PreferenceHelper
import com.tarweej.mypost.repo.homepage.DataSource
import com.tarweej.mypost.repo.homepage.RemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule() {


    @Singleton
    @Provides
    fun provideTasksRemoteDataSource(apiService: APIServices): DataSource {
        return RemoteDataSource(apiService)
    }




    @Provides
    fun providePreferenceHelper(context: Context): PreferenceHelper {
        return PreferenceHelper(context)
    }

}
