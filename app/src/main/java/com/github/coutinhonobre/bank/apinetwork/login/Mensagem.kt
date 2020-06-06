package com.github.coutinhonobre.bank.apinetwork.login

data class Mensagem(
    var tipo: TipoMensagem = TipoMensagem.ERROR,
    var descricao: String
)