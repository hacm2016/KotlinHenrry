package com.example.productofinal.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfiguration {

    companion object {
        private var retrofit: Retrofit? = null

        @Synchronized
        fun getConfiguration(/*context: Context*/): Retrofit {
            if (retrofit == null) {
                val username = ""
                val password = ""

                retrofit = Retrofit.Builder()
                    //.client(client.build())
                    .baseUrl(EndPoint.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }


    }
}