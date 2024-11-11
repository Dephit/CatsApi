package com.example.myapplication.okhttp_client

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHolder {

  private val okHttpClient = OkHttpClient.Builder()
    .build()

  private val retrofit = Retrofit.Builder()
    .baseUrl("https://cat-fact.herokuapp.com")
    .addConverterFactory(GsonConverterFactory.create())
    .client(okHttpClient)
    .build()

  val catsApi = retrofit.create(CatsApi::class.java)
}
