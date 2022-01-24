package com.example.funfact.network

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface FunFactInterface {

    @GET("/api?format=json")
    fun getFacts(): Call<FunFact>
}