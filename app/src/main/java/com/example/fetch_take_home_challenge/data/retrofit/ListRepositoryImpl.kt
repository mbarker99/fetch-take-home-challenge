package com.example.fetch_take_home_challenge.data.retrofit

import com.example.fetch_take_home_challenge.data.retrofit.dto.toListItem
import com.example.fetch_take_home_challenge.domain.model.ListItem
import com.example.fetch_take_home_challenge.domain.util.Result
import com.example.fetch_take_home_challenge.domain.repository.ListRepository
import javax.inject.Inject

class ListRepositoryImpl @Inject constructor(
    private val api: ListApi
): ListRepository {
    override suspend fun getList(): Result<List<ListItem>> {
        return try {
            val response = api.getList()
            if (response.isSuccessful) {
                Result.Success(response.body()?.map { it.toListItem() }!!)
            } else {
                Result.Error("Error: ${response.message()}")
            }
        } catch (e: Exception) {
            Result.Error("Error: ${e.message}")
        }
    }
}