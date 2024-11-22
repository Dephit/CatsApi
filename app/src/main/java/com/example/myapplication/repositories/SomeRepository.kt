package com.example.myapplication.repositories

import com.example.myapplication.okhttp_client.CatsApi
import com.example.myapplication.okhttp_client.FactDto
import javax.inject.Inject

class SomeRepository @Inject constructor(
  private val catsApi: CatsApi
) {

  suspend fun getFacts(): List<FactDto> {
    return catsApi.getFacts()
  }

}
