package com.ithena.userdetails

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL="https://dummyjson.com/"
class MainActivity : AppCompatActivity() {

    lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerview_user.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerview_user.layoutManager=linearLayoutManager

        getMyData()
    }

    private fun getMyData() {

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<User>?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<List<User>?>,
                response: Response<List<User>?>
            ) {
                val responseBody = response.body()!!

                userAdapter = UserAdapter(baseContext, responseBody)
                userAdapter.notifyDataSetChanged()

                recyclerview_user.adapter = userAdapter
            }

            override fun onFailure(call: Call<List<User>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure:" + t.message)
            }
        })
    }
}


