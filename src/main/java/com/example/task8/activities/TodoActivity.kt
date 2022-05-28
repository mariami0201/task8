package com.example.task8.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.task8.R
import com.example.task8.adapters.TodoRecyclerAdapter.Companion.USER_ID
import com.example.task8.api.RestClient
import com.example.task8.api.dto.ReqResData
import com.example.task8.api.dto.Todo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodoActivity : AppCompatActivity() {
    private lateinit var nameView: TextView
    private lateinit var yearView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        nameView = findViewById(R.id.textView4)
        yearView = findViewById(R.id.textView5)

        val userId = intent.extras?.getLong(USER_ID, -1)
        if (userId != -1L){
            RestClient.reqResApi.getTodos(userId!!).enqueue(object :
                Callback<ReqResData<Todo>> {
                override fun onResponse(
                    call: Call<ReqResData<Todo>>,
                    response: Response<ReqResData<Todo>>
                ) {
                    if (response.isSuccessful){
                        response.body()?.data?.let {
                            nameView.text = it.name
                            yearView.text = it.year.toString()
                        }
                    }
                }

                override fun onFailure(call: Call<ReqResData<Todo>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }
    }}