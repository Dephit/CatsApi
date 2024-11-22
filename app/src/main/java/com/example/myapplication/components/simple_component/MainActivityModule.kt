package com.example.myapplication.components.simple_component

import com.example.myapplication.okhttp_client.CatsApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://cat-fact.herokuapp.com"

@Module
interface MainActivityModule {

  @Binds
  fun bindBindsExampleInterface(impl: BindsExampleInterfaceImpl): BindsExampleInterface

  companion object {

    @Provides
    fun provideOkHttp(): OkHttpClient {
      return OkHttpClient.Builder()
        .build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
      return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
    }

    @Provides
    fun provideCatsApi(retrofit: Retrofit): CatsApi {
      return retrofit.create(CatsApi::class.java)
    }

  }

}
