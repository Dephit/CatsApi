package com.example.myapplication.repositories

import com.example.myapplication.okhttp_client.FactDto
import com.example.myapplication.okhttp_client.RetrofitHolder

class SomeRepository {

  private val retrofitHolder = RetrofitHolder()

  suspend fun getFacts(): List<FactDto> {
    return retrofitHolder.catsApi.getFacts()
  }

}
