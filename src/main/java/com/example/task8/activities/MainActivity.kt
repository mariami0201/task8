package com.example.task8.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task8.R
import com.example.task8.adapters.TodoRecyclerAdapter
import com.example.task8.api.RestClient
import com.example.task8.api.dto.ReqResData
import com.example.task8.api.dto.Todo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RestClient.initClient()
        RestClient.reqResApi.getTodos(2).enqueue(object :
            Callback<ReqResData<List<Todo>>> {
            override fun onResponse(
                call: Call<ReqResData<List<Todo>>>,
                response: Response<ReqResData<List<Todo>>>
            ) {
                if(response.isSuccessful){
                    response.body()?.data?.let {
                        recyclerView.adapter = TodoRecyclerAdapter(it)
                        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                }
            }

            override fun onFailure(call: Call<ReqResData<List<Todo>>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}