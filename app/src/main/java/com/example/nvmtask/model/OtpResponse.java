package com.example.nvmtask.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OtpResponse {

    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("user_auth")
    @Expose
    private Integer userAuth;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(Integer userAuth) {
        this.userAuth = userAuth;
    }

}
