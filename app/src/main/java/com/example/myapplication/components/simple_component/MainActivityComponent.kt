package com.example.myapplication.components.simple_component

import android.content.Context
import com.example.myapplication.Dependencies
import com.example.myapplication.MainActivity
import com.example.myapplication.MainActivityPresenterFactory
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent

@Component(
  modules = [
    MainActivityModule::class,
    IntoSetModule::class
  ]
)
interface MainActivityComponent {

  fun subComponentFactory(): MainActivitySubComponent.Factory

  fun contextDependedClass(): ContextDependedClass

  fun presenterFactory(): MainActivityPresenterFactory

  fun dependencies(): Dependencies

  fun inject(activity: MainActivity)

  @Component.Builder()
  interface Builder {

    @BindsInstance
    fun bindContext(context: Context): Builder

    fun build(): MainActivityComponent
  }

}

@Subcomponent
interface MainActivitySubComponent {

  @Subcomponent.Factory
  interface Factory {
    fun create(): MainActivitySubComponent
  }

}
