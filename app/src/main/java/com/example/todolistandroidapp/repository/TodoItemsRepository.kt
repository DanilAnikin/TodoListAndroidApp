package com.example.todolistandroidapp.repository

import com.example.todolistandroidapp.model.Importance
import com.example.todolistandroidapp.model.TodoItem

object TodoItemsRepository {
    private val _todoItemList: MutableList<TodoItem> = initTodoItemList()
    val todoItemList: MutableList<TodoItem> get() = _todoItemList

    fun addTodoItem(todoItem: TodoItem) {
        _todoItemList.add(todoItem)
    }

    private fun initTodoItemList(): MutableList<TodoItem> {
        return mutableListOf<TodoItem>().apply {
            add(TodoItem(id = "0", text = "Купить что-то", Importance.HIGH, deadline = "123", isDone = false, creationDate = ""))
            add(TodoItem(id = "1", text = "Купить что-то", Importance.HIGH, deadline = "123", isDone = true, creationDate = ""))
            add(TodoItem(id = "2", text = "Купить что-то", Importance.NORMAL, deadline = "", isDone = true, creationDate = ""))
            add(TodoItem(id = "3", text = "Купить что-то Купить что-то Купить что-то Купить что-то Купить что-то Купить что-то Купить что-то", Importance.NORMAL, deadline = "23", isDone = false, creationDate = ""))
            add(TodoItem(id = "4", text = "Купить что-то", Importance.HIGH, deadline = "", isDone = false, creationDate = ""))
            add(TodoItem(id = "5", text = "Купить что-то", Importance.NORMAL, deadline = "", isDone = true, creationDate = ""))
            add(TodoItem(id = "6", text = "Купить что-то", Importance.NORMAL, deadline = "123", isDone = false, creationDate = ""))
            add(TodoItem(id = "7", text = "Купить что-то", Importance.NORMAL, deadline = "", isDone = false, creationDate = ""))
            add(TodoItem(id = "8", text = "Купить что-то", Importance.HIGH, deadline = "", isDone = false, creationDate = ""))
            add(TodoItem(id = "9", text = "Купить что-то", Importance.HIGH, deadline = "", isDone = true, creationDate = ""))
            add(TodoItem(id = "10", text = "Купить что-то", Importance.NORMAL, deadline = "", isDone = false, creationDate = ""))
            add(TodoItem(id = "11", text = "Купить что-то", Importance.NORMAL, deadline = "", isDone = false, creationDate = ""))
            add(TodoItem(id = "12", text = "Купить что-то Купить что-то Купить что-то Купить что-то Купить что-то Купить что-то Купить что-то Купить что-то Купить что-то", Importance.HIGH, deadline = "", isDone = false, creationDate = ""))
            add(TodoItem(id = "13", text = "Купить что-то", Importance.NORMAL, deadline = "", isDone = false, creationDate = ""))
            add(TodoItem(id = "14", text = "Купить что-то", Importance.NORMAL, deadline = "", isDone = false, creationDate = ""))
            add(TodoItem(id = "15", text = "Купить что-то", Importance.NORMAL, deadline = "123", isDone = true, creationDate = ""))
            add(TodoItem(id = "16", text = "Купить что-то", Importance.HIGH, deadline = "", isDone = false, creationDate = ""))
            add(TodoItem(id = "17", text = "Купить что-то", Importance.LOW, deadline = "", isDone = false, creationDate = ""))
            add(TodoItem(id = "18", text = "Купить что-то", Importance.NORMAL, deadline = "213", isDone = false, creationDate = ""))
            add(TodoItem(id = "19", text = "Купить что-то", Importance.LOW, deadline = "", isDone = true, creationDate = ""))
            add(TodoItem(id = "20", text = "Купить что-то", Importance.HIGH, deadline = "123", isDone = false, creationDate = ""))
        }
    }
}