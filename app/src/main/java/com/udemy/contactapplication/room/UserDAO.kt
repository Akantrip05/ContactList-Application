package com.udemy.contactapplication.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDAO  {
    @Insert
    suspend fun insertUser(user: User):Long

    @Update
    suspend fun updateUser(user: User) {}

    @Delete
    suspend fun deleteUser(user: User){}

    // Custom queries
    @Query("DELETE FROM user")
    suspend fun deleteAll(){}

    @Query("SELECT * FROM user")
   fun selectAll(): LiveData<List<User>>

}