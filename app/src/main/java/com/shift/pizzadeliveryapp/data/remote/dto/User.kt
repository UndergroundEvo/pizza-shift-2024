package com.shift.pizzadeliveryapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("_id")
    val id: String,
    val phone: String
)