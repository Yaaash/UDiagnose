package com.health.udiagnose.symptoms

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.health.udiagnose.R

class SymptomsActivity : AppCompatActivity(), SymptomsNavigator {

    private var viewModel: SymptomsViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_symptoms)
        viewModel = SymptomsViewModel(applicationContext)
        viewModel?.symptomsNavigator = this
    }

    override fun onNextClicked() {

    }

    override fun onDestroy() {
        viewModel?.onActivityDestroyed()
        super.onDestroy()
    }
}
