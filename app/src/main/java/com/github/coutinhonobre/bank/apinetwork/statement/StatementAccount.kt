package com.github.coutinhonobre.bank.apinetwork.statement

import android.os.Parcelable
import com.github.coutinhonobre.bank.data.model.Statement
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StatementAccount(
    val statementList : List<Statement>
) : Parcelable