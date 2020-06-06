package com.github.coutinhonobre.bank.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.github.coutinhonobre.bank.data.model.UserAccount

@Dao
interface UserAccountDao {

    @Query("select * from users")
    fun getAllLiveUserAccount(): LiveData<List<UserAccount>>

    @Insert
    fun addSingleCliente(userAccount: UserAccount)

    @Query("DELETE FROM users")
    fun deleteUserAccount()

}
