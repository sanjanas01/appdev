package com.example.vit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.vit.database.Item
import com.example.vit.database.ItemDAO
import com.example.vit.database.Itemroomdb
import com.example.vit.databinding.ActivityHomeBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var dao: ItemDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = Itemroomdb.getDatabase(this)
        dao = database.itemDao()

        binding.btnDbInsert.setOnClickListener {
            insertDataDb()
        }
    }

    private fun insertDataDb() {
        GlobalScope.launch {
            val item = Item(name = "dosa", price = 99.99, quantity = 2)
            dao.insert(item)
        }
    }
}
