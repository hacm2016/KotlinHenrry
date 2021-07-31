package com.example.productofinal.net.security.interact

import com.example.productofinal.net.RetrofitConfiguration
import com.example.productofinal.net.security.SecurityEndPoint
import com.example.productofinal.net.security.callback.LoginCallback
import com.example.productofinal.net.security.response.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginInteract {

    fun login(callback: LoginCallback, username: String, password: String) {
        val retrofit = RetrofitConfiguration.getConfiguration().create(SecurityEndPoint::class.java)
        val call = retrofit.validateUser(username, password)
        call.enqueue(object : Callback<UserResponse> {
            override fun onResponse(
                call: Call<UserResponse>,
                response: Response<UserResponse>
            ) {
                val body = response.body()
                if (body != null) {
                    callback.onLoginSuccess(body)
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                callback.onLoginError("Error: ${t.message}")
            }
        })
    }
}