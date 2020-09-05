package com.example.praveenpayasimachinetest.data.remote.response

import android.provider.ContactsContract
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserListResponse (
    @Expose
    @SerializedName("id")
    var id: Int,

    @Expose
    @SerializedName("name")
    var name: String,

    @Expose
    @SerializedName("email")
    var email: String,

    @Expose
    @SerializedName("address")
    var address: AddressData,

    @Expose
    @SerializedName("company")
    var company: Company) {


    data class Company(
        @Expose
        @SerializedName("name")
        var name: String
    )
}


data class AddressData(
        @Expose
        @SerializedName("city")
        var city: String
    )















