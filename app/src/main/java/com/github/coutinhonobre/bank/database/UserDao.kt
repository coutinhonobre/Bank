package com.github.coutinhonobre.bank.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.github.coutinhonobre.bank.data.model.UserNetWork

@Dao
interface UserDao {

    @Query("select * from user order by id desc")
    fun getAllUser(): LiveData<List<UserNetWork>>

    @Query("select * from user where user = :user")
    fun getListAll(user: String): List<UserNetWork>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSingleUser(userNetWork: UserNetWork)

    @Update
    fun updateUser(userNetWork: UserNetWork)

    @Query("DELETE FROM user")
    fun deleteUser()


}