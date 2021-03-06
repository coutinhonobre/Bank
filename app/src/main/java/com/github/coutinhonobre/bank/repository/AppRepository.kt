package com.github.coutinhonobre.bank.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.github.coutinhonobre.bank.apinetwork.ApiRetrofit
import com.github.coutinhonobre.bank.apinetwork.login.LoginUserAccount
import com.github.coutinhonobre.bank.apinetwork.login.Mensagem
import com.github.coutinhonobre.bank.apinetwork.login.TipoMensagem
import com.github.coutinhonobre.bank.apinetwork.statement.StatementList
import com.github.coutinhonobre.bank.data.model.Statement
import com.github.coutinhonobre.bank.data.model.UserAccount
import com.github.coutinhonobre.bank.data.model.UserNetWork
import com.github.coutinhonobre.bank.database.AppDataBase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class AppRepository(val context: Context) {

    var mensagem = MutableLiveData<Mensagem>(Mensagem(tipo = TipoMensagem.NOT, descricao = ""))

    var getUserAccount = ApiRetrofit.RETROFIT_SERVICE

    var statementListLiveData = MutableLiveData<MutableList<Statement>>()

    private val database = AppDataBase.getInstance(context)

    fun getUltimoUser() = database.Dao().getAllUser()

    fun getConta() = database.Dao().getAllLiveUserAccount()


    fun fetchDataFromServerUsuarios(userNetWork: UserNetWork) {

        getUserAccount.getUsuarios(userNetWork).enqueue(object : Callback<LoginUserAccount>{
            override fun onFailure(call: Call<LoginUserAccount>, t: Throwable) {
                mensagem.apply {
                    value = Mensagem(TipoMensagem.ERROR, "Requisicao Falhou!")
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

                    GlobalScope.launch {
                        adicaoUser(userNetWork)
                        adicaoUserAccount(userAccount)
                    }

                }else{
                    mensagem.apply {
                        value = Mensagem(TipoMensagem.ERROR, "${response.code()} - ${response.errorBody()}")
                    }
                }

            }

        })

    }

    fun getchDataFromServerStatements(id: String){
        getUserAccount.getExtratos(id).enqueue(object : Callback<StatementList>{
            override fun onFailure(call: Call<StatementList>, t: Throwable) {
                mensagem.apply {
                    value = Mensagem(TipoMensagem.ERROR, "Requisicao Falhou!")
                }
            }

            override fun onResponse(call: Call<StatementList>, response: Response<StatementList>) {
                if (response.isSuccessful){
                    mensagem.apply {
                        value = Mensagem(TipoMensagem.SUCCESS, "${response.code()} - ${response.body()}")
                    }

                    var statementList = response.body()!!.statementList

                    statementListLiveData.apply {
                        value = statementList
                    }


                }else{
                    mensagem.apply {
                        value = Mensagem(TipoMensagem.ERROR, "${response.code()} - ${response.errorBody()}")
                    }
                }
            }

        })
    }

    private fun adicaoUserAccount(userAccount: UserAccount) {
        database.Dao().deleteUserAccount()
        database.Dao().addSingleCliente(userAccount)
    }

    private fun adicaoUser(userNetWork: UserNetWork) {
        database.Dao().deleteUser()
        database.Dao().addSingleUser(userNetWork)
    }

}