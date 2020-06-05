package com.github.coutinhonobre.bank.presentation.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.coutinhonobre.bank.R
import com.github.coutinhonobre.bank.presentation.extrato.ExtratoActivity
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {
            startActivity(Intent(this, ExtratoActivity::class.java))
        }

    }
}
