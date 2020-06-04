package com.github.coutinhonobre.bank.data.model

data class Account(
    val userId: Int,
    val name: String,
    val bankAccount: String,
    val agency: String,
    val balance: Double
) {
}