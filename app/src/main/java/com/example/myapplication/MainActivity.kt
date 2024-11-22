package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.components.simple_component.BindsExampleInterface
import com.example.myapplication.components.simple_component.ClassForMainActivity
import com.example.myapplication.components.simple_component.DaggerMainActivityComponent
import com.example.myapplication.components.simple_component.MainActivityComponent
import com.example.myapplication.components.simple_component.MainActivitySubComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

  private var mainActivityComponent: MainActivityComponent? = null
  private var subComponent: MainActivitySubComponent? = null
  private var secondComponent: SecondComponent? = null

  private var presenter: MainActivityPresenter? = null

  @Inject
  lateinit var classForMainActivity: ClassForMainActivity

  @Inject
  lateinit var bindsExampleInterface: BindsExampleInterface

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initMainActivityComponent()
    presenter?.attach()
    enableEdgeToEdge()
    setContentView(R.layout.activity_main)
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
      val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
      insets
    }
  }

  private fun initMainActivityComponent() {
    mainActivityComponent = DaggerMainActivityComponent.builder()
      .bindContext(this)
      .build()
    mainActivityComponent?.inject(this)
    presenter = mainActivityComponent?.presenterFactory()?.create(this)
    subComponent = mainActivityComponent?.subComponentFactory()?.create()
    mainActivityComponent?.let {
      secondComponent = DaggerSecondComponent.factory().create(it.dependencies())
    }

    println(classForMainActivity.getClassName())
    println(secondComponent?.contextDependedClass())
    println(bindsExampleInterface.javaClass)
    println(mainActivityComponent?.contextDependedClass()?.getPackageName())
  }

  override fun onDestroy() {
    presenter?.detach()
    presenter = null
    mainActivityComponent = null
    secondComponent = null
    subComponent = null
    super.onDestroy()
  }

  override fun showValue(value: String) {
    findViewById<TextView>(R.id.cats_fact_text).apply {
      this.text = value
    }
  }
}
