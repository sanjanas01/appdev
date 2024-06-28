package com.example.vit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var a = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        var b = 20
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun some(){
        println(a)
    }
}