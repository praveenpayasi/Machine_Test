package com.example.praveenpayasimachinetest.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class User(

   /* @Expose
    @SerializedName("name")
    val name: String,

    @Expose
    @SerializedName("id")
    val userId : Int,

    @Expose
    @SerializedName("email")
    val email : String,

    @Expose
    @SerializedName("city")
    val city : String,

    @Expose
    @SerializedName("name")
    val companyName : String*/

    @Expose
    @SerializedName("id")
    var id: Int,

    @Expose
    @SerializedName("name")
    var name: String,

    @Expose
    @SerializedName("email")
    var email: String)

   /* @Expose
    @SerializedName("address")
    var address: AddressData,*/

    /*@Expose
    @SerializedName("company")
    var company: Company) {


    data class Company(
        @Expose
        @SerializedName("name")
        var name: String
    )*/
//}


/*
data class AddressData(
    @Expose
    @SerializedName("city")
    var city: String

)*/
