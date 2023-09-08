package com.udemy.contactapplication.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udemy.contactapplication.room.UserRepo

class UserViewModelFactory(private  val repo: UserRepo):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModelFactory::class.java)){
            return UserViewMOdel(repo) as T
        }
          throw java.lang.IllegalArgumentException("Unknown View Model")
    }

}