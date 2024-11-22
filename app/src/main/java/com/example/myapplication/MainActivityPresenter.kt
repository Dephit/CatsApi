package com.example.myapplication

import com.example.myapplication.components.simple_component.Car
import com.example.myapplication.repositories.SomeRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AssistedFactory
interface MainActivityPresenterFactory {

  fun create(view: MainView): MainActivityPresenter
}

class MainActivityPresenter @AssistedInject constructor(
  @Assisted
  private val view: MainView,
  private val someRepository: SomeRepository,
  private val carSet: Set<@JvmSuppressWildcards Car>
) {

  private val scope: CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

  fun attach() {
    carSet.forEach {
      println(it.javaClass.name)
    }
    scope.launch(Dispatchers.IO) {
      val facts = someRepository.getFacts().firstOrNull()
      withContext(Dispatchers.Main) {
        view.showValue(
          value = facts?.text ?: "Ничего нету :)"
        )
      }
    }
  }

  fun detach() {
    scope.cancel()
  }

}
