package com.shift.pizzadeliveryapp.domain.models


import com.google.gson.annotations.SerializedName

data class Person(
    val firstname: String,
    val lastname: String,
    val middlename: String,
    val phone: String
)