package com.example.myapplication.components.simple_component

import javax.inject.Inject

class ClassForMainActivity @Inject constructor() {

  fun getClassName(): String {
    return javaClass.name
  }

}
