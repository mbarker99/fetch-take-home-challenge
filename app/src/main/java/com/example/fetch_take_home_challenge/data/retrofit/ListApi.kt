package com.example.fetch_take_home_challenge.data.retrofit

import com.example.fetch_take_home_challenge.data.retrofit.dto.ListItemDto
import com.example.fetch_take_home_challenge.domain.model.ListItem
import retrofit2.Response
import retrofit2.http.GET

interface ListApi {
    @GET("/hiring.json")
    suspend fun getList() : Response<List<ListItemDto>>
}