package com.example.todolistandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todolistandroidapp.databinding.ActivityTodoItemBinding

class TodoItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTodoItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.todoItemScreenToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }
}