package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.api.ApiInterface
import com.example.myapplication.api.ExampleResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val apiInterface: ApiInterface by lazy {
        RetrofitInstance.getInstance().create(ApiInterface::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getExampleData()
    }

    private fun getExampleData() {
        val call = apiInterface.getExampleData()
        call.enqueue(object : Callback<ExampleResponse> {
            override fun onResponse(call: Call<ExampleResponse>, response: Response<ExampleResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val data = response.body()
                    // TODO: Process data
                    println("Data: $data")
                } else {
                    println("Error: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<ExampleResponse>, t: Throwable) {
                t.printStackTrace()
                println("API call failed: ${t.message}")
            }
        })
    }
}
