package com.example.myapplication.okhttp_client

import com.google.gson.annotations.SerializedName

data class FactDto(
  @SerializedName("_id")
  val _id: String? = null,
  @SerializedName("status")
  val status: Status? = null,
  @SerializedName("__v")
  val __v: Int? = null,
  @SerializedName("type")
  val type: String? = null,
  @SerializedName("user")
  val user: String? = null,
  @SerializedName("text")
  val text: String? = null,
  @SerializedName("updatedAt")
  val updatedAt: String? = null,
  @SerializedName("deleted")
  val deleted: Boolean? = null,
  @SerializedName("createdAt")
  val createdAt: String? = null,
  @SerializedName("source")
  val source: String? = null,
  @SerializedName("sentCount")
  val sentCount: Int? = null,
)

data class Status(
  @SerializedName("verified")
  val verified: Boolean? = null,
  @SerializedName("feedback")
  val feedback: String? = null,
  @SerializedName("sentCount")
  val sentCount: Int? = null,
)
