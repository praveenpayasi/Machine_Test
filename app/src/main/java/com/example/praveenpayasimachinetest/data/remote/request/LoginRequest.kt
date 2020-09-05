package com.example.praveenpayasimachinetest.data.remote.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.security.PrivateKey

data class LoginRequest(

    @Expose
    @SerializedName("email")
    var email : String,

    @Expose
    @SerializedName("password")
    var password: String
)