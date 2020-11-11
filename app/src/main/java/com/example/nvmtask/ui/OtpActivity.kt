package com.example.nvmtask.ui

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.nvmtask.R
import com.example.nvmtask.databinding.ActivityOtpBinding
import com.example.nvmtask.model.OtpResponse
import com.example.nvmtask.viewmodel.OtpViewModel


class OtpActivity : AppCompatActivity() {

    var mobileNo : String = ""
    private lateinit var binidng : ActivityOtpBinding
    private lateinit var otpViewModel: OtpViewModel
    var otpNo : String = ""

     private lateinit var timer : CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        mobileNo = intent.getStringExtra("mobileNo")!!
        binidng = DataBindingUtil.setContentView(this,R.layout.activity_otp)
        binidng.mobileNo.text = mobileNo
        binidng.changeNumber.paintFlags = binidng.changeNumber.getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG
        binidng.txtTimer.paintFlags = binidng.changeNumber.getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG

        setTimer()

        otpViewModel = ViewModelProviders.of(this).get(OtpViewModel::class.java)


        binidng.otpNo1.addTextChangedListener(object : TextWatcher
        {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if(s!!.length == 1)
                {
                    binidng.otpNo2.requestFocus()
                }

            }

        })

        binidng.otpNo2.addTextChangedListener(object : TextWatcher
        {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if(s!!.length == 1)
                {
                    binidng.otpNo3.requestFocus()
                }else
                {
                    binidng.otpNo1.requestFocus()
                }

            }

        })
        binidng.otpNo3.addTextChangedListener(object : TextWatcher
        {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if(s!!.length == 1)
                {
                    binidng.otpNo4.requestFocus()
                }else
                {
                    binidng.otpNo2.requestFocus()
                }

            }

        })
        binidng.otpNo4.addTextChangedListener(object : TextWatcher
        {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if(s!!.length == 1)
                {
                    otpNo = binidng.otpNo1.text.toString() + binidng.otpNo2.text.toString() +binidng.otpNo3.text.toString() +binidng.otpNo4.text.toString()
                    Toast.makeText(this@OtpActivity,otpNo, Toast.LENGTH_LONG).show()
                }else
                {
                    binidng.otpNo3.requestFocus()
                    otpNo = ""
                }

            }

        })


        binidng.verify.setOnClickListener {
            if(otpNo.isNotEmpty())
            {
                otpViewModel.verifyOtp(mobileNo,otpNo).observe(this,object : Observer<OtpResponse>
                {
                    override fun onChanged(t: OtpResponse?) {

                        if(t!!.status.equals("Success"))
                        {
                            startActivity(Intent(this@OtpActivity,MainActivity::class.java))
                            finish()
                        }else
                        {
                            Toast.makeText(this@OtpActivity,t.status,Toast.LENGTH_LONG).show()
                        }
                    }

                })
            }
        }




    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }

    private fun setTimer() {

         timer = object: CountDownTimer(30000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                val seconds = (millisUntilFinished / 1000).toInt() % 60
                val minutes = (millisUntilFinished / (1000 * 60) % 60)
                binidng.txtTimer.text =  ""+minutes+ " : "+seconds
            }

            override fun onFinish() {
                binidng.txtTimer.text = "RESEND OTP"
            }
        }
        timer.start()
    }

}