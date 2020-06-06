package com.github.coutinhonobre.bank.apinetwork

import com.github.coutinhonobre.bank.apinetwork.login.LoginUserAccount
import com.github.coutinhonobre.bank.apinetwork.login.User
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


private const val BASE_URL = "https://bank-app-test.herokuapp.com/api/"

/*
objeto Moshi que o Retrofit usará
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService{


    @Headers("Content-Type: application/json")
    @POST("login")
    fun getUsuarios(@Body user: User):
            Call<LoginUserAccount>

}



