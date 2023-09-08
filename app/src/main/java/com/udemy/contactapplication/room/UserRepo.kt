package com.udemy.contactapplication.room

class UserRepo(private var dao: UserDAO){

    var users = dao.selectAll()

    suspend fun insert(user: User):Long{
        return dao.insertUser(user)
    }
    suspend fun delete(user: User) {
       return dao.deleteUser(user)
    }

    suspend fun uddate(user: User){
        return dao.updateUser(user)
    }
    suspend fun deleteAll(){
        return dao.deleteAll()
    }
}