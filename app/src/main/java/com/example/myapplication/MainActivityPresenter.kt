package com.example.myapplication

import com.example.myapplication.repositories.SomeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityPresenter(
  private val view: MainView
) {

  private val someRepository = SomeRepository()

  private val scope: CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

  fun attach() {
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
