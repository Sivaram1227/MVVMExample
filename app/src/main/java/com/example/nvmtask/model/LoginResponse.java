package com.example.nvmtask.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("mobile_no")
    @Expose
    private String mobileNo;
    @SerializedName("otp_code_mobile")
    @Expose
    private Integer otpCodeMobile;
    @SerializedName("country_code")
    @Expose
    private String countryCode;
    @SerializedName("Status")
    @Expose
    private String status;

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Integer getOtpCodeMobile() {
        return otpCodeMobile;
    }

    public void setOtpCodeMobile(Integer otpCodeMobile) {
        this.otpCodeMobile = otpCodeMobile;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
