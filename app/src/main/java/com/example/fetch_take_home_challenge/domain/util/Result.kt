package com.example.fetch_take_home_challenge.domain.util


sealed class Result<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Result<T>(data)
    class Error<T>(message: String, data: T? = null) : Result<T>(data, message)
    class Loading<T>(data:T? = null) : Result<T>(data)
}