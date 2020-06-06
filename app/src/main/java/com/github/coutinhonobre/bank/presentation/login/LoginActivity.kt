package com.github.coutinhonobre.bank.presentation.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.coutinhonobre.bank.R
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
                startActivity(Intent(this, ExtratoActivity::class.java))
            }else{
                val contextView: View = findViewById(R.id.constraintLayoutLogin)
                Snackbar.make(contextView, user.error, Snackbar.LENGTH_SHORT)
                    .show();
            }
        }

    }
}
