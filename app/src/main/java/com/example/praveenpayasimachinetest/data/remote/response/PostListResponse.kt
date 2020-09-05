package com.example.praveenpayasimachinetest.data.remote.response

import com.example.praveenpayasimachinetest.data.model.Post
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PostListResponse(
    @Expose
    @SerializedName("statusCode")
    var statusCode: String,

    @Expose
    @SerializedName("message")
    var message: String,

    @Expose
    @SerializedName("data")
    val data: List<Post>
)