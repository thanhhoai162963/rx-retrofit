package com.example.retrofit_rx_recyclerview.model

data class Medicine(
    val `data`: Base,
    val errors: Errors,
    val message: String,
    val success: Boolean,
    val utcTime0: String
)