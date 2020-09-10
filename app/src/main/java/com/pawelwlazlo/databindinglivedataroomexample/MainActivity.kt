package com.pawelwlazlo.databindinglivedataroomexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pawelwlazlo.databindinglivedataroomexample.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel: MainViewModel =
            ViewModelProvider(this, MainViewModelFactory(this.application))
                .get<MainViewModel>(
                    MainViewModel::class.java
                )

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
            .apply {
                this.lifecycleOwner = this@MainActivity
                this.viewmodel = mainViewModel
            }

        mainViewModel.newName.observe(this, Observer {
            nameTV.text=it

        })
    }
}