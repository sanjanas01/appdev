package com.example.vit

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.vit.network.MarsApi
import com.example.vit.network.MarsPhoto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class HomeActivity : AppCompatActivity(){
    var TAG = HomeActivity::class.java.simpleName    //"HomeActivity"

    lateinit var marsRecyclerView:RecyclerView
    lateinit var marsAdapter: MarsAdapter
    lateinit var photos:List<MarsPhoto>
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        imageView = findViewById(R.id.imageView2)
        marsRecyclerView = findViewById(R.id.recyclerViewUrls)
        marsRecyclerView.layoutManager = LinearLayoutManager(this)
        photos = ArrayList()
        marsAdapter = MarsAdapter(photos)
        marsRecyclerView.adapter = marsAdapter

        // marsAdapter = MarsAdapter(photos)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }


    private fun getMarsPhotos() {
        GlobalScope.launch(Dispatchers.Main) {

            var listMarsPhotos =   MarsApi.retrofitService.getPhotos()

            marsAdapter.listMarsPhotos = listMarsPhotos

            imageView.load(listMarsPhotos.get(0).imgSrc)
            marsAdapter.notifyDataSetChanged()

            Log.i("homeactiviy",listMarsPhotos.size.toString())
            Log.i("url",listMarsPhotos.get(1).imgSrc)


        }
    }

    fun getJson(view: View) {
        getMarsPhotos()
    }

}