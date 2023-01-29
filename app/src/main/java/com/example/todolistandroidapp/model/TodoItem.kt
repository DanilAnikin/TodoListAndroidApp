package com.example.todolistandroidapp.model

data class TodoItem(
    val id: String,
    val text: String,
    val importance: Importance,
    val deadline: String = "",
    val isDone: Boolean,
    val creationDate: String
)