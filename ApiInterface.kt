package com.example.myapplication.api

import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    @GET("end/point")
    fun getExampleData(): Call<ExampleResponse>
}
