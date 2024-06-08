package com.example.vit

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickMethod(view: View) {
        Log.i("MainActivity-click method","Next page")
        var dialIntent:Intent=Intent(Intent.ACTION_DIAL, Uri.parse("tel:+916369053568"))
        var webIntent:Intent=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.github.com"))
        startActivity(webIntent)
    }
}