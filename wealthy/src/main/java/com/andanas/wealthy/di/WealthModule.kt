package com.andanas.wealthy.di

import com.andanas.wealthy.data.remote.CoinApi
import com.andanas.wealthy.data.repository.CoinRepositoryImpl
import com.andanas.wealthy.domain.repository.ICoinRepository
import com.globant.utilities.constants.AppConstants
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
class WealthModule {

    @Provides
    @Singleton
    fun provideCoinPaprikaApi(): CoinApi {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient().newBuilder()
        httpClient.addInterceptor(httpLoggingInterceptor)

        val interceptor = Interceptor { chain ->
            val request = chain.request().newBuilder().build()
            chain.proceed(request)
        }

        httpClient.addInterceptor(interceptor)

        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_COIN_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
            .create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun providesCoinRepository(api: CoinApi): ICoinRepository {
        return CoinRepositoryImpl(api)
    }
}