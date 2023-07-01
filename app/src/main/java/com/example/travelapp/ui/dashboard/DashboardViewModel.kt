package com.example.travelapp.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.travelapp.network.IMDBResult
import com.example.travelapp.repository.IMDBRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardViewModel(
    private val imdbRepository: IMDBRepository
) : ViewModel() {

    private val _travelResult = MutableLiveData<IMDBResult>()
    val teamResult: LiveData<IMDBResult> = _travelResult

    fun getTeams(search: String) {
        viewModelScope.launch {
            imdbRepository.getTeams().enqueue(object : Callback<IMDBResult> {
                override fun onResponse(call: Call<IMDBResult>, response: Response<IMDBResult>) {
                    _travelResult.value = response.body()
                }
                override fun onFailure(call: Call<IMDBResult>, t: Throwable) {
                }
            })
        }
    }
}