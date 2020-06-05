package com.github.coutinhonobre.bank.apinetwork.login

import android.os.Parcelable
import com.github.coutinhonobre.bank.data.model.UserAccount
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginUserAccount(
    val userAccount : UserAccount
) : Parcelable