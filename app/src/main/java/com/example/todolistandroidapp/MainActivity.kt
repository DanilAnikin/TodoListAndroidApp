package com.example.todolistandroidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistandroidapp.adapter.TodoItemListAdapter
import com.example.todolistandroidapp.databinding.ActivityMainBinding
import com.example.todolistandroidapp.model.Importance
import com.example.todolistandroidapp.model.TodoItem
import com.example.todolistandroidapp.repository.TodoItemsRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.tvDoneCounter.text = getString(R.string.toolbar_tv_done_counter, TodoItemsRepository.todoItemList.count { it.isDone })

        val todoItemListAdapter = TodoItemListAdapter()

        binding.rvTodoItemList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            adapter = todoItemListAdapter
        }

        binding.fab.setOnClickListener {
            Intent(this@MainActivity, TodoItemActivity::class.java).also { startActivity(it) }
        }
    }
}