package com.udemy.contactapplication.ViewModel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udemy.contactapplication.room.User
import com.udemy.contactapplication.room.UserRepo
import kotlinx.coroutines.launch

class UserViewMOdel(private var repo: UserRepo):ViewModel(),Observable {
  // connecting the view model with the repository
    val users = repo.users
    private var isUpdOrDlt = true
    private lateinit var userToUpdOrDlt : User


    @Bindable
    val inputName = MutableLiveData<String>()

    @Bindable
    val inputEmail = MutableLiveData<String>()

    @Bindable
    val saveOrUpdateBtnTxt = MutableLiveData<String>()

  @Bindable
  val clearAllOrDeleteButtonTxt = MutableLiveData<String>()

  init {
      saveOrUpdateBtnTxt.value = "Save"
    clearAllOrDeleteButtonTxt.value = "Clear All"
  }

  fun saveOrUpdate(){
    val name  = inputName.value!!
    val email = inputEmail.value!!

    insert(User(0,name , email))
    inputName.value = null
    inputEmail.value = null
  }

  fun clearAllOrDelete(){
    clearAll()
  }
  fun insert(user: User) = viewModelScope.launch {
    repo.insert(user)
  }

  fun  delete(user: User) = viewModelScope.launch {
    repo.delete(user)
  }

  fun update(user: User) = viewModelScope.launch {
    repo.uddate(user)
  }

  fun clearAll() = viewModelScope.launch {
    repo.deleteAll()
  }

  override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    TODO("Not yet implemented")
  }

  override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    TODO("Not yet implemented")
  }

    fun initUpdateAndDelete(selectedItem: User) {

    }
}