package com.example.aplicationtestinglayout.api

import com.example.aplicationtestinglayout.model.Tarefas
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiService {

    @GET("Tarefas")
    suspend fun listTasks(): Response<List<Tarefas>>

    @POST("api/todo")
    suspend fun addTarefa(
        @Body tarefas: Tarefas
    ): Response<Tarefas>

    @PUT("api/todo")
    suspend fun updateTarefa(
        @Body tarefas: Tarefas
    ): Response<Tarefas>

}