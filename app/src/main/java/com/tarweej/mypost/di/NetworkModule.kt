package com.tarweej.mypost.di

import android.content.Context
import com.tarweej.mypost.ActivityBuildersModule
import com.tarweej.mypost.datalayer.APIServices
import com.tarweej.mypost.helper.Constants.Companion.BASE_URL
import com.tarweej.mypost.helper.FragmentFactoryModule
import com.tarweej.mypost.helper.PreferenceHelper
import com.tarweej.mypost.helper.ViewModelBuilderModule
import com.tarweej.mypost.presentation.auth.sign_in_fragment.SingInFragment
import com.tarweej.mypost.presentation.famousprofilefragment.FamousProfileFragment
import com.tarweej.mypost.presentation.homefragment.HomeFragment
import com.tarweej.mypost.presentation.myorders.MyOrdersFragment
import com.tarweej.mypost.presentation.notification.NotificationFragment
import com.tarweej.mypost.presentation.profile.ProfileFragment
import com.tarweej.mypost.presentation.request.FinishRequestFragment
import com.tarweej.mypost.presentation.request.FirstRequestFragment
import com.tarweej.mypost.presentation.request.SecondRequestFragment
import com.tarweej.mypost.presentation.request.ThirdRequestFragment
import com.tarweej.mypost.presentation.famous_fragment.FamousFragment
import com.tarweej.mypost.presentation.settingsfragment.SettingsFragment

import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 *
 * @author juancho.
 */
@Singleton
@Component(
    modules =
    [   DispatcherModule::class,
        AndroidInjectionModule::class,
        APIModule::class,
        AppModule::class,
        FragmentFactoryModule::class,
        MainModule::class,
        ActivityBuildersModule::class,
        FragmentFactoryModule::class,
        ViewModelBuilderModule::class,

    ]
)



interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    fun inject(app: HomeFragment)
    fun inject(app: ProfileFragment)
    fun inject(app: FirstRequestFragment)
    fun inject(app: SecondRequestFragment)
    fun inject(app: ThirdRequestFragment)
    fun inject(app: FinishRequestFragment)
    fun inject(app: FamousFragment)
    fun inject(app: NotificationFragment)
    fun inject(app: FamousProfileFragment)
    fun inject(app: MyOrdersFragment)
    fun inject(app: SingInFragment)
    fun inject(app: SettingsFragment)



}


@Module
class APIModule constructor() {

    @Singleton
    @Provides
    fun provideHttpClient(context: Context): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor { chain: Interceptor.Chain ->
                val originalRequest = chain.request()
                val Pref = PreferenceHelper(context)
                val builder = originalRequest.newBuilder()
             //   builder.addHeader("Accept", "application/json")
                builder.addHeader("Content-Type", "application/json")
            //    builder.addHeader("Authorization", "Bearer " + Pref.token)
//                Log.d("token",Pref.token!!)
                val newRequest = builder.build()
                chain.proceed(newRequest)
            }
            .build()
    }

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun ApiServices(retrofit: Retrofit): APIServices = retrofit.create(APIServices::class.java)


}
