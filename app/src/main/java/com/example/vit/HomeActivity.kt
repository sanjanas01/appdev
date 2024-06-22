package com.example.vit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.vit.database.Item
import com.example.vit.database.ItemDAO
import com.example.vit.database.Itemroomdb
import com.example.vit.databinding.ActivityHomeBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var dao: ItemDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = Itemroomdb.getDatabase(this)
        dao = database.itemDao()

        binding.insert.setOnClickListener {
            insert1()
        }

        binding.view.setOnClickListener {
            view(2)
        }
    }

    private fun insert1() {
        GlobalScope.launch {
            val item = Item(name = "dosa", price = 99.99, quantity = 2)
            dao.insert(item)
        }
    }

    private fun view(id: Int) {
        GlobalScope.launch(Dispatchers.Main) {
            val item = dao.getItem(id).firstOrNull() // Use firstOrNull() to handle null case
            if (item != null) {
                binding.tvHome.text = item.name
            } else {
                // Handle case where item with the given ID is not found
                binding.tvHome.text = "Item not found"
            }
        }
    }


}
