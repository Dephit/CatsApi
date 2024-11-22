package com.example.myapplication.components.simple_component

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet
import javax.inject.Inject

@Module
interface IntoSetModule {

  @Binds
  @IntoSet
  fun bindCar1(car: Car1): Car

  @Binds
  @IntoSet
  fun bindCar2(car: Car2): Car


}

interface Car

class Car1 @Inject constructor(): Car

class Car2 @Inject constructor(): Car
