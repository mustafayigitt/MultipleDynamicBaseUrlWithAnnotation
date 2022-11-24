package com.mustafayigit.multipledynamicbaseurlwithannotation.di

import com.mustafayigit.multipledynamicbaseurlwithannotation.base.BaseUrlInterceptor
import com.mustafayigit.multipledynamicbaseurlwithannotation.data.remote.AuthService
import com.mustafayigit.multipledynamicbaseurlwithannotation.data.remote.ContentService
import com.mustafayigit.multipledynamicbaseurlwithannotation.data.remote.PaymentService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * Created by Mustafa Yiğit on 23/11/2022
 * mustafa.yt65@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideBaseUrlInterceptor(
    ): BaseUrlInterceptor {
        return BaseUrlInterceptor()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        baseUrlInterceptor: BaseUrlInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(baseUrlInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun providerRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthService(
        retrofit: Retrofit
    ): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Provides
    @Singleton
    fun provideContentService(
        retrofit: Retrofit
    ): ContentService {
        return retrofit.create(ContentService::class.java)
    }

    @Provides
    @Singleton
    fun providePaymentService(
        retrofit: Retrofit
    ): PaymentService {
        return retrofit.create(PaymentService::class.java)
    }

}