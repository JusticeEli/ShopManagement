package com.justice.shopmanagement.di

import android.content.Context
import com.justice.shopmanagement.data.remote.ShopManagerService
import com.justice.shopmanagement.repository.ShopRepository
import com.justice.shopmanagement.repository.SolanaRepository
import com.justice.shopmanagement.utils.Constants
import com.justice.shopmanagement.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideRetrofitService(): ShopManagerService {

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build().create(ShopManagerService::class.java)
    }


    @Provides
    @Singleton
    fun provideSharedPreference(@ApplicationContext context: Context)=
        context.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE)
    @Provides
    @Singleton
    fun provideShopRepository(service: ShopManagerService):ShopRepository{


       return  SolanaRepository(service)

    }



}
