package com.github.coutinhonobre.bank.presentation.login

import android.content.Intent
import android.graphics.Color
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
            button.isEnabled = false
            progressBar.visibility = View.VISIBLE

            if (user.isValido()){

                loginViewModel.refreshData(User(user.user, user.password))

                loginViewModel.mensagem.observe(this, Observer {
                    if (it.tipo != TipoMensagem.NOT) {
                        if (it.tipo == TipoMensagem.SUCCESS) {
                            user.error = it.descricao
                            voltarEstadoBotaoLogin()
                            startActivity(Intent(this, ExtratoActivity::class.java))
                        } else {
                            user.error = it.descricao
                            mensagemSnack(user, true)
                        }
                    }
                })

            }else{
                mensagemSnack(user, true)
            }
        }


    }

    private fun mensagemSnack(user: com.github.coutinhonobre.bank.data.model.User, error: Boolean) {
        val contextView: View = findViewById(R.id.constraintLayoutLogin)
        var snackbar = Snackbar.make(contextView, user.error, Snackbar.LENGTH_SHORT)
        snackbar.setActionTextColor(if (error) Color.RED else Color.BLUE)
        snackbar.show()
        voltarEstadoBotaoLogin()
    }

    private fun voltarEstadoBotaoLogin() {
        button.isEnabled = true
        progressBar.visibility = View.GONE
    }

    override fun onResume() {
        super.onResume()

        loginViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(LoginViewModel::class.java)

    }
}
