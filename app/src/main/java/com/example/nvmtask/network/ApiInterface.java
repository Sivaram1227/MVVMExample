package com.example.nvmtask.network;

import com.example.nvmtask.model.LoginResponse;
import com.example.nvmtask.model.OtpResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
public interface ApiInterface {

    @FormUrlEncoded
    @POST("signUp")
    Call<LoginResponse> loginUser(@Field("mobile") String mobile);

    @FormUrlEncoded
    @POST("verify_new")
    Call<OtpResponse> verifyOtp( @Field("mobile") String mobile,
                                 @Field("otp") String otp);

}