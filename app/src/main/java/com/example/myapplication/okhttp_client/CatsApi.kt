package com.example.myapplication.okhttp_client

import retrofit2.http.GET
import retrofit2.http.Query

interface CatsApi {

  @GET("/facts/random")
  suspend fun getFacts(
    @Query("animal_type") animalType: String = "cat",
    @Query("amount") amount: Int = 2
  ): List<FactDto>
}
