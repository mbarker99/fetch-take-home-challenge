package com.example.fetch_take_home_challenge.domain.repository

import com.example.fetch_take_home_challenge.domain.model.ListItem
import com.example.fetch_take_home_challenge.domain.util.Result

interface ListRepository {
    suspend fun getList(): Result<List<ListItem>>
}