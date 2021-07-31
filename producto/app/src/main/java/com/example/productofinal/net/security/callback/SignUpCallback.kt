package com.example.productofinal.net.security.callback

import com.example.productofinal.net.security.response.UserResponse

interface SignUpCallback {
    fun onSignUpSuccess(response: UserResponse)
    fun onSignUpError(message: String)
}