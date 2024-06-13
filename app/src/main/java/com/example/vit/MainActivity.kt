package com.example.vit

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.vit.kotlinex.Egjava
class MainActivity : AppCompatActivity() {
    var TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inflate this xml
        setContentView(R.layout.activity_main)
        Log.i(TAG,"activity is getting created")

    }

    //activity is visible to the user to interact - click
    override fun onStart() {
        super.onStart()
        Log.e(TAG,"activity is started")
    }

    //sleep night -- incomming call ur activity goes into the background for sometime
    override fun onPause() {
        super.onPause()
        Log.w(TAG,"activity has paused")

    }

    // activity no longer exists in the ram -- pushed to hdd[hibernate]
    override fun onStop() {
        super.onStop()
        Log.d(TAG,"activity is stopped")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG,"activity is destroyed")
    }

    fun clickMethod(view: View) {
        Log.i("MainActivity-clickMethod","button clicked")
        val y=sub(14,5)
        var hIntent:Intent = Intent(this,HomeActivity::class.java)
        hIntent.putExtra("nkey","sanjana")
        startActivity(hIntent)
    }

    private fun sub(x: Int,y: Int):Int
    {
        var c = 20
        var d = 20 * x
        //mult(5,4)
        return x-y

    }
    private fun mult(a:Int,b:Int)
    {
        val c=a*b
        div(9,8)
    }

    fun div(k:Int,p:Int)
    {
        sub(30,40)
    }
    /*
    fun String.mynewmethod(values:String)
    {
        "add this to it"+values;
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
    */
}