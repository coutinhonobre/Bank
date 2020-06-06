package com.github.coutinhonobre.bank.presentation.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.github.coutinhonobre.bank.apinetwork.login.User
import com.github.coutinhonobre.bank.repository.AppRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {


    private val appRepository = AppRepository(application)

    var mensagem = appRepository.mensagem

    fun refreshData(user: User) = appRepository.fetchDataFromServerUsuarios(user)



}
