package com.github.coutinhonobre.bank.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.github.coutinhonobre.bank.apinetwork.ApiRetrofit
import com.github.coutinhonobre.bank.apinetwork.login.LoginUserAccount
import com.github.coutinhonobre.bank.apinetwork.login.Mensagem
import com.github.coutinhonobre.bank.apinetwork.login.TipoMensagem
import com.github.coutinhonobre.bank.apinetwork.login.User
import com.github.coutinhonobre.bank.data.model.UserAccount

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class AppRepository(val context: Context) {

    var mensagem = MutableLiveData<Mensagem>(Mensagem(tipo = TipoMensagem.NOT, descricao = ""))

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
                    mensagem.apply {
                        value = Mensagem(TipoMensagem.SUCCESS, "${response.code()} - ${response.body()}")
                    }
                    var userAccount = response.body()!!.userAccount

                }else{
                    mensagem.value.apply {
                        Mensagem(TipoMensagem.ERROR, "${response.code()} - ${response.errorBody()}")
                    }
                }

            }

        })

    }

}