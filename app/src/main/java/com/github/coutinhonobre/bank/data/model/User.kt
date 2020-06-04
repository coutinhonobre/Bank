package com.github.coutinhonobre.bank.data.model

import java.util.regex.Pattern

class User {

    lateinit var user: String
    lateinit var password: String
    var error: String = ""

    val EMAIL_ADDRESS_PATTERN = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )


    fun isValido(): Boolean {
        if ((user.isNotEmpty() || user.isNotBlank()) && (password.isNotBlank() || password.isNotEmpty())) {
            return if (validarUsuario()) {
                validacaoPassword()
            } else false
        }

        return false

    }

    private fun validacaoPassword(): Boolean{
        var valido = password.contains(Regex("[A-Z]")) &&
                password.contains(Regex("[0-9]")) &&
                password.contains(Regex("[^a-zA-Z0-9 ]"))

        if (!valido) this.error = "Senha Invalida"
        println(this.error)
        return valido
    }


    private fun validarUsuario(): Boolean {
        var valido = EMAIL_ADDRESS_PATTERN.matcher(this.user)
            .matches() || ((this.user.length == 11 || this.user.length == 14) && !this.user.contains(
            "^[a-Z]"
        ))

        if (!valido) this.error = "Usuario Invalido"

        return valido

    }
}