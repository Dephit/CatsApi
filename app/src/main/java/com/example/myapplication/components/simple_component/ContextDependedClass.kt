package com.example.myapplication.components.simple_component

import android.content.Context
import javax.inject.Inject

class ContextDependedClass @Inject constructor(
  private val context: Context
) {

  fun getPackageName(): String {
    return context.packageName
  }
}
