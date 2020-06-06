package com.github.coutinhonobre.bank.presentation.extrato

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.github.coutinhonobre.bank.repository.AppRepository

class ExtratoViewModel(application: Application): AndroidViewModel(application) {

    private val appRepository = AppRepository(application)

    var userAccount = appRepository.getConta()

}