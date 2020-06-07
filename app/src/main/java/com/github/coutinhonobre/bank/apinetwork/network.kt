package com.github.coutinhonobre.bank.apinetwork

import com.github.coutinhonobre.bank.apinetwork.login.LoginUserAccount
import com.github.coutinhonobre.bank.apinetwork.statement.StatementList
import com.github.coutinhonobre.bank.data.model.UserNetWork
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*


private const val BASE_URL = "https://bank-app-test.herokuapp.com/api/"
private const val TYPE_HEADERS = "Content-Type: application/json"

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


    @Headers(TYPE_HEADERS)
    @POST("login")
    fun getUsuarios(@Body userNetWork: UserNetWork):
            Call<LoginUserAccount>

    @Headers(TYPE_HEADERS)
    @GET("statements/{id}")
    fun getExtratos(@Path("id") id: String): Call<StatementList>

}


object ApiRetrofit {
    val RETROFIT_SERVICE : ApiService by lazy { retrofit.create(ApiService::class.java) }
}



