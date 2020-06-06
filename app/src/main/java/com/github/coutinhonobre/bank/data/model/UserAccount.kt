package com.github.coutinhonobre.bank.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "users")
data class UserAccount(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    @ColumnInfo(name = "user")
    val userId: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "account")
    val bankAccount: String,
    @ColumnInfo(name = "agency")
    val agency: String,
    @ColumnInfo(name = "balance")
    val balance: Double
) : Parcelable