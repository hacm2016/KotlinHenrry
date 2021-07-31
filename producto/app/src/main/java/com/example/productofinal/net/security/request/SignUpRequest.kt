package com.example.productofinal.net.security.request

data class SignUpRequest(
    val name: String,
    val lastName: String,
    val username: String,
    val password: String,
    val email: String,
    val address: String,
    val phone: String
)