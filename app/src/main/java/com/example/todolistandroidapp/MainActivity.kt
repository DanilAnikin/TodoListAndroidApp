package com.example.todolistandroidapp

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistandroidapp.adapter.TodoItemListAdapter
import com.example.todolistandroidapp.databinding.ActivityMainBinding
import com.example.todolistandroidapp.repository.TodoItemsRepository
import com.google.android.material.appbar.AppBarLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val todoItemListAdapter = TodoItemListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.mainScreenToolbar)
        binding.tvDoneCounter.text = getString(
            R.string.toolbar_tv_done_counter,
            TodoItemsRepository.todoItemList.count { it.isDone })


//        binding.appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
//            val toolbarAnimation = (appBarLayout.background as AnimationDrawable).apply {
////                setEnterFadeDuration(600)
////                setExitFadeDuration(600)
//            }
//            toolbarAnimation.start()
//        })


        binding.rvTodoItemList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            adapter = todoItemListAdapter
        }

        binding.fab.setOnClickListener {
            Intent(this@MainActivity, TodoItemActivity::class.java).also { startActivity(it) }
        }
    }
}