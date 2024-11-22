package com.example.myapplication

import com.example.myapplication.components.simple_component.ContextDependedClass
import dagger.Component
import javax.inject.Inject

class Dependencies @Inject constructor(
  val contextDependedClass: ContextDependedClass
)

@Component(dependencies = [Dependencies::class])
interface SecondComponent {

  fun contextDependedClass(): ContextDependedClass

  @Component.Factory
  interface Factory {
    fun create(dependencies: Dependencies): SecondComponent
  }

}
