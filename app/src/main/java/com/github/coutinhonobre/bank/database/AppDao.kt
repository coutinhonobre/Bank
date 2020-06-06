package com.github.coutinhonobre.bank.database

import androidx.room.Dao
import com.github.coutinhonobre.bank.data.model.UserAccount

@Dao
interface AppDao: UserAccountDao, UserDao