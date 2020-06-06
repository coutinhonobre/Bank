package com.github.coutinhonobre.bank.presentation.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.coutinhonobre.bank.R
import com.github.coutinhonobre.bank.apinetwork.login.TipoMensagem
import com.github.coutinhonobre.bank.apinetwork.login.User
import com.github.coutinhonobre.bank.presentation.extrato.ExtratoActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {
            var user = com.github.coutinhonobre.bank.data.model.User()
            user.user = textInputEditUser.text.toString()
            user.password = textInputEditPassword.text.toString()
            if (user.isValido()){

                loginViewModel.refreshData(User(user.user, user.password))

                loginViewModel.mensagem.observe(this, Observer {
                    if (it.tipo == TipoMensagem.SUCCESS){
                        startActivity(Intent(this, ExtratoActivity::class.java))
                    }else{
                        user.error = it.descricao
                        mensagemSnack(user)
                    }
                })

            }else{
                mensagemSnack(user)
            }
        }


    }

    private fun mensagemSnack(user: com.github.coutinhonobre.bank.data.model.User) {
        val contextView: View = findViewById(R.id.constraintLayoutLogin)
        Snackbar.make(contextView, user.error, Snackbar.LENGTH_SHORT)
            .show();
    }

    override fun onResume() {
        super.onResume()

        loginViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(LoginViewModel::class.java)

    }
}
