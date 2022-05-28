package com.example.task8.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task8.R
import com.example.task8.activities.TodoActivity
import com.example.task8.api.dto.Todo

class TodoRecyclerAdapter(private val todos: List<Todo>): RecyclerView.Adapter<TodoRecyclerAdapter.TodoViewHolder>() {
    companion object {
        const val USER_ID = "USER_ID"
    }
    class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{

        init {
            itemView.setOnClickListener(this)
        }

        private val nameView: TextView = itemView.findViewById(R.id.textView)
        private val yearView: TextView = itemView.findViewById(R.id.textView2)
        private lateinit var todo: Todo

        fun onBind(todo: Todo){
            nameView.text = todo.name
            yearView.text = todo.year.toString()
        }

        override fun onClick(clickedView: View?) {
            val context = itemView.context
            val intent = Intent(context, TodoActivity::class.java)
            intent.putExtra(USER_ID, todo.id)
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.onBind(todos[position])
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}