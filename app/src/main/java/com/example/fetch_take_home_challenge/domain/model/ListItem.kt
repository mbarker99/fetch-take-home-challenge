package com.example.fetch_take_home_challenge.domain.model

import com.google.gson.annotations.SerializedName

data class ListItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("listId")
    val listId: Int,
    @SerializedName("name")
    val name: String?
)
