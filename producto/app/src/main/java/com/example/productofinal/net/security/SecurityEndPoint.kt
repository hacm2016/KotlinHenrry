package com.example.productofinal.net.security

import com.example.productofinal.net.EndPoint
import com.example.productofinal.net.security.request.SignUpRequest
import com.example.productofinal.net.security.response.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SecurityEndPoint {
    @POST(EndPoint.CREATE_USER)
    fun createUser(
        @Body request: SignUpRequest
    ): Call<UserResponse>

    @POST(EndPoint.VALIDATE_USER)
    @FormUrlEncoded
    fun validateUser(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<UserResponse>
}