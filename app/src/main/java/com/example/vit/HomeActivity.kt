package com.example.vit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.vit.HomeViewModel
import com.example.vit.database.Item
import com.example.vit.database.ItemDAO
import com.example.vit.database.Itemroomdb
import com.example.vit.databinding.ActivityHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    var TAG = HomeActivity::class.java.simpleName    //"HomeActivity"
    private lateinit var binding: ActivityHomeBinding
    lateinit var dao: ItemDAO
    lateinit var viewModel: HomeViewModel
    //var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var  database = Itemroomdb.getDatabase(this)
        dao = database.itemDao()
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        //binding.tvHome.setText(""+count)
        binding.tvHome.setText(""+viewModel.count)
        binding.insert.setOnClickListener{
            insertDataDb()
        }
        binding.view.setOnClickListener{
            findItemDb(21)
        }
        binding.inc.setOnClickListener{
//            count++
//            viewModel.incrementCount()
//            binding.tvHome.setText(""+count)
//            +viewModel.count)
            viewModel.incrementCount()
            binding.tvHome.setText(""+viewModel.count)
        }
    }

    fun add(a:Int,b:Int):Int{
        return a+b
    }

    private fun findItemDb(id: Int) {
        GlobalScope.launch(Dispatchers.Main) {
            var item = dao.getItem(id).first()
            binding.tvHome.setText(item.name)
        }
    }

    private fun insertDataDb() {
        GlobalScope.launch {
            var item = Item(19,"apple",29.38,3)
            dao.insert(item)
        }
    }

}