package com.example.nvmtask.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.nvmtask.model.OtpResponse
import com.example.nvmtask.network.ApiClient
import com.example.nvmtask.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object OtpRepository
{

    fun verifyOTP(mobile : String,otp : String) : MutableLiveData<OtpResponse>
    {

        val data : MutableLiveData<OtpResponse> = MutableLiveData()
        val apiCall: ApiInterface = ApiClient.client!!.create(ApiInterface::class.java)

        apiCall.verifyOtp(mobile,otp).enqueue(object : Callback<OtpResponse>
        {
            override fun onFailure(call: Call<OtpResponse>?, t: Throwable?) {
                Log.e("Error in Login","----->"+t!!.localizedMessage)
            }

            override fun onResponse(
                call: Call<OtpResponse>?,
                response: Response<OtpResponse>?
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