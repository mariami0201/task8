package com.example.task8.api

import com.example.task8.api.dto.ReqResData
import com.example.task8.api.dto.Todo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ReqResService {
    @GET("todo")
    fun getTodos(@Query("page")page: Int): Call<ReqResData<List<Todo>>>
    @GET("todo/{todoId}")
    fun getTodos(@Query("todoId")id: Long): Call<ReqResData<Todo>>
}