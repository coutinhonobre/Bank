package com.github.coutinhonobre.bank.presentation.extrato

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.coutinhonobre.bank.R
import kotlinx.android.synthetic.main.cabecalho_extrato.*

class ExtratoActivity : AppCompatActivity() {

    private lateinit var loginViewModel: ExtratoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extrato)

        loginViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(ExtratoViewModel::class.java)

        loginViewModel.userAccount.observe(this, Observer {
            if (it.isNotEmpty()) {
                textViewCabecalhoExtratoNome.setText(it[0].name)
                textViewCabecalhoExtratoContaNumero.setText(it[0].bankAccount)
                textViewCabecalhoExtratoSaldo.setText(it[0].balance.toString())
            }
        })

        imageViewCabecalhoExtratoLogout.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onResume() {
        super.onResume()

    }
}
