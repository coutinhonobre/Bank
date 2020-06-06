package com.github.coutinhonobre.bank.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.github.coutinhonobre.bank.data.model.UserNetWork

@Dao
interface UserDao {

    @Query("select * from user")
    fun getAllUser(): LiveData<List<UserNetWork>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSingleUser(userNetWork: UserNetWork)

    @Update
    fun updateUser(userNetWork: UserNetWork)

    @Delete
    fun delete()


}