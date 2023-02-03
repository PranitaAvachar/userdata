package com.ithena.userdetails

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
@GET("users")
    fun getData(): Call<List<User>>
}