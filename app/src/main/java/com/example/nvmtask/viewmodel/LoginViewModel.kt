package com.example.nvmtask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nvmtask.model.LoginResponse
import com.example.nvmtask.repo.LoginRepository

class LoginViewModel : ViewModel()
{

    private  var loginRes : MutableLiveData<LoginResponse>? = null

    fun loginUser(mobile : String) : LiveData<LoginResponse>
    {
        loginRes = LoginRepository.loginUserRepo(mobile)
        return loginRes!!
    }

}