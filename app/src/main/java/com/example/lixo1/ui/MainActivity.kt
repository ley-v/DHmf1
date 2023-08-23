package com.example.lixo1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lixo1.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // AULA4
}