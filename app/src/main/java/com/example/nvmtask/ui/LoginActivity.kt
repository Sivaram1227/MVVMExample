package com.example.nvmtask.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.nvmtask.R
import com.example.nvmtask.databinding.ActivityLoginBinding
import com.example.nvmtask.model.LoginResponse
import com.example.nvmtask.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)


        binding.submit.setOnClickListener {
            if(binding.mobileNumber.text.toString().isNotEmpty())
            loginViewModel.loginUser(binding.mobileNumber.text.toString()).observe(this,object : Observer<LoginResponse>
            {
                override fun onChanged(t: LoginResponse?) {
                    Log.e("Otp","---->"+t!!.otpCodeMobile)
                    val intent = Intent(this@LoginActivity,OtpActivity::class.java)
                    intent.putExtra("mobileNo",binding.mobileNumber.text.toString())
                    startActivity(intent)
                }

            })
            else
                Toast.makeText(this,"Enter mobile number",Toast.LENGTH_LONG).show()
        }




    }


}