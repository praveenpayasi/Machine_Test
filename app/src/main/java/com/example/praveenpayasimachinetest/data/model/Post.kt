package com.example.praveenpayasimachinetest.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Post(

    @Expose
    @SerializedName("id")
    val postId : Int,

    @Expose
    @SerializedName("userId")
    val userId : Int,

    @Expose
    @SerializedName("title")
    val title : String,

    @Expose
    @SerializedName("body")
    val body : String
)