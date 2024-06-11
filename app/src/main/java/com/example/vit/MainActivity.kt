package com.example.vit

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickMethod(view: View) {
        Log.i("MainActivity-click method", "Next page")
        //var dialIntent:Intent=Intent(Intent.ACTION_DIAL, Uri.parse("tel:+916369053568"))
        // var webIntent:Intent=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.github.com"))
        // startActivity(webIntent)
        var hIntent = Intent(this, HomeActivity::class.java)
        hIntent.putExtra("nkey", "sanjana")
        startActivity(hIntent)

        fun createAlarm(message: String, hour: Int, minutes: Int) {
            val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, message)
                putExtra(AlarmClock.EXTRA_HOUR, hour)
                putExtra(AlarmClock.EXTRA_MINUTES, minutes)
            }
            //if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
            //
        }
    }
}