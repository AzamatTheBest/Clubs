package com.example.travelapp.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/api/v1/teams")
    fun getTeamsBySearch(): Call<IMDBResult>
}