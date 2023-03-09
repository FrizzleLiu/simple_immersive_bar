package com.frizzle.bar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.frizzle.immersivebar.immersiveBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        immersiveBar()
        setContentView(R.layout.activity_main)
    }
}