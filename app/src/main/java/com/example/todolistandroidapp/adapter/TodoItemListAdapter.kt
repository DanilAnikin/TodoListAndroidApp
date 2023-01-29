package com.example.todolistandroidapp.adapter

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Paint
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistandroidapp.R
import com.example.todolistandroidapp.databinding.TodoItemBinding
import com.example.todolistandroidapp.model.Importance
import com.example.todolistandroidapp.model.TodoItem
import com.example.todolistandroidapp.repository.TodoItemsRepository

class TodoItemListAdapter : RecyclerView.Adapter<TodoItemListAdapter.TodoItemViewHolder>() {

    private var todoItemList = TodoItemsRepository.todoItemList

    class TodoItemViewHolder(private val binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val context = binding.root.context
        fun bindView(todoItem: TodoItem) {
            binding.cbItemIsDone.isChecked = todoItem.isDone
            binding.tvItemText.text = todoItem.text
            binding.tvWithDeadline.isVisible = todoItem.deadline.isNotEmpty()
            binding.ivItemImportance.visibility = View.VISIBLE

            if (todoItem.isDone) {
                bindDoneTodoItemView()
                return
            }

            binding.tvItemText.paintFlags = 0
            binding.tvItemText.setTextColor(getColorAttribute(context, R.attr.color_label_primary))

            when (todoItem.importance) {
                Importance.HIGH -> {
                    binding.cbItemIsDone.buttonTintList = ColorStateList.valueOf(getColorAttribute(context, R.attr.color_red))
                    binding.ivItemImportance.setImageResource(R.drawable.ic_double_exclamation_mark)

                }
                Importance.NORMAL -> {
                    binding.cbItemIsDone.buttonTintList = ColorStateList.valueOf(getColorAttribute(context, R.attr.color_label_tertiary))
                    binding.ivItemImportance.visibility = View.GONE
                }
                Importance.LOW -> {
                    binding.cbItemIsDone.buttonTintList = ColorStateList.valueOf(getColorAttribute(context, R.attr.color_label_tertiary))
                    binding.ivItemImportance.setImageResource(R.drawable.ic_arrow_downward)

                }
            }
        }

        private fun bindDoneTodoItemView() {
            binding.apply {
                ivItemImportance.visibility = View.GONE
                cbItemIsDone.buttonTintList = ColorStateList.valueOf(getColorAttribute(context, R.attr.color_green))
                tvItemText.setTextColor(getColorAttribute(context, R.attr.color_label_tertiary))
                tvItemText.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            }
        }

        private fun getColorAttribute(context: Context, attrId: Int): Int {
            val colorValue = TypedValue()
            context.theme.resolveAttribute(attrId, colorValue, true)
            return colorValue.data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TodoItemBinding.inflate(inflater, parent, false)
        return TodoItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        holder.bindView(todoItemList[position])
    }

    override fun getItemCount(): Int = todoItemList.size
}