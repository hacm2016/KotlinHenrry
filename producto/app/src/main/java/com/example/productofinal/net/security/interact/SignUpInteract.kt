package com.example.productofinal.net.security.interact

import com.example.productofinal.net.RetrofitConfiguration
import com.example.productofinal.net.security.SecurityEndPoint
import com.example.productofinal.net.security.callback.SignUpCallback
import com.example.productofinal.net.security.request.SignUpRequest
import com.example.productofinal.net.security.response.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpInteract {
    fun signUp(
        callback: SignUpCallback,
        username: String,
        name: String,
        lastName: String,
        email: String,
        password: String,
        phone: String,
        address: String
    ) {
        val retrofit = RetrofitConfiguration.getConfiguration().create(SecurityEndPoint::class.java)
        val call = retrofit.createUser(SignUpRequest(name, lastName, username, password, email, address, phone))
        call.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                val body = response.body()
                if (body != null) {
                    callback.onSignUpSuccess(body)
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                callback.onSignUpError("Error: ${t.message}")
            }
        })
    }
}