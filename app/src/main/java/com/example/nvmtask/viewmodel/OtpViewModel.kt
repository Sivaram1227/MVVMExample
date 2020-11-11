package com.example.nvmtask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nvmtask.model.OtpResponse
import com.example.nvmtask.repo.OtpRepository

class OtpViewModel : ViewModel()
{
    private  var otpRes : MutableLiveData<OtpResponse>? = null

    fun verifyOtp(mobile : String,otp: String) : LiveData<OtpResponse>
    {
        otpRes = OtpRepository.verifyOTP(mobile,otp)
        return otpRes!!
    }
}