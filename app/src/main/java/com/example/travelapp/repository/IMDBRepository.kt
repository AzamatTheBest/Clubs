package com.example.travelapp.repository

import com.example.travelapp.network.ApiService


class IMDBRepository(
    private val apiService: ApiService
) {
    fun getTeams() = apiService.getTeamsBySearch()
}