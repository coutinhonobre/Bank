package com.github.coutinhonobre.bank.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.github.coutinhonobre.bank.apinetwork.ApiRetrofit
import com.github.coutinhonobre.bank.apinetwork.login.LoginUserAccount
import com.github.coutinhonobre.bank.apinetwork.login.Mensagem
import com.github.coutinhonobre.bank.apinetwork.login.TipoMensagem
import com.github.coutinhonobre.bank.apinetwork.login.User

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class AppRepository(val context: Context) {

    lateinit var mensagem: LiveData<Mensagem>
    var getUserAccount = ApiRetrofit.RETROFIT_SERVICE


    fun fetchDataFromServerUsuarios(user: User) {

        getUserAccount.getUsuarios(user).enqueue(object : Callback<LoginUserAccount>{
            override fun onFailure(call: Call<LoginUserAccount>, t: Throwable) {
                mensagem.value.apply {
                    Mensagem(TipoMensagem.ERROR, "Requisicao Falou")
                }
            }

            override fun onResponse(
                call: Call<LoginUserAccount>,
                response: Response<LoginUserAccount>
            ) {

                if (response.isSuccessful){
                    Mensagem(TipoMensagem.SUCCESS, "${response.code()} - ${response.body()}")
                }else{
                    mensagem.value.apply {
                        Mensagem(TipoMensagem.ERROR, "${response.code()} - ${response.errorBody()}")
                    }
                }

            }

        })

    }

}