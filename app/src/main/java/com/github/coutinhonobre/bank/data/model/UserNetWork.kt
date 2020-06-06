package com.github.coutinhonobre.bank.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserNetWork(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    @ColumnInfo(name = "user")
    val user: String?,
    @ColumnInfo(name = "password")
    val password: String?
)