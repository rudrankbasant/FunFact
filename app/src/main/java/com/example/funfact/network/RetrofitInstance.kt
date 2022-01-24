package com.example.funfact.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: FunFactInterface by lazy {
        Retrofit.Builder()
            .baseUrl("https://geek-jokes.sameerkumar.website")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FunFactInterface::class.java)
    }
}