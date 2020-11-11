package com.example.nvmtask.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.nvmtask.model.LoginResponse
import com.example.nvmtask.network.ApiClient
import com.example.nvmtask.network.ApiInterface

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object LoginRepository
{

    fun loginUserRepo(mobile : String) : MutableLiveData<LoginResponse>
    {

        val data : MutableLiveData<LoginResponse> = MutableLiveData()
        val apiCall: ApiInterface = ApiClient.client!!.create(ApiInterface::class.java)

        apiCall.loginUser(mobile).enqueue(object : Callback<LoginResponse>
        {
            override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {
                Log.e("Error in Login","----->"+t!!.localizedMessage)
            }

            override fun onResponse(
                call: Call<LoginResponse>?,
                response: Response<LoginResponse>?
            ) {
                if(response!!.isSuccessful)
                {
                    data.value = response.body()
                }
            }


        })

        return data
    }



}