package com.example.tmdbfinalapp.features

import android.os.Bundle
import com.example.tmdbfinalapp.R
import com.example.tmdbfinalapp.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

