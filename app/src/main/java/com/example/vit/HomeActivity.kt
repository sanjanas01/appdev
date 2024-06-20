package com.example.vit

import CustomAdapter
import android.os.Bundle


import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vit.network.Item


class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var customAdapter: CustomAdapter
    private lateinit var itemList: MutableList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        itemList = mutableListOf()
        // Add sample data
        itemList.add(Item("https://t3.ftcdn.net/jpg/05/58/14/66/360_F_558146635_Pjgj1F8Au64JTeB9VGuas0Fm09OhEOGh.jpg", false))
        itemList.add(Item("https://butterry.com/image/cache/catalog/buttery/sq-choco-vanilla-cake0006chva-AA-1000x1000.jpg", true))
        // Add more items as needed

        customAdapter = CustomAdapter(this, itemList)
        recyclerView.adapter = customAdapter
    }
}