package com.example.praveenpayasimachinetest.data.remote.request

import android.provider.ContactsContract
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SignUpRequest(

    @Expose
    @SerializedName("email")
    var email: String,

    @Expose
    @SerializedName("password")
    var password:String,

    @Expose
    @SerializedName("name")
    var name:String
)