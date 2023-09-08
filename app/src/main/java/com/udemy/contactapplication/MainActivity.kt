package com.udemy.contactapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.udemy.contactapplication.UI.MyRecyclerView
import com.udemy.contactapplication.ViewModel.UserViewMOdel
import com.udemy.contactapplication.ViewModel.UserViewModelFactory
import com.udemy.contactapplication.databinding.ActivityMainBinding
import com.udemy.contactapplication.room.User
import com.udemy.contactapplication.room.UserDataBase
import com.udemy.contactapplication.room.UserRepo

class MainActivity : AppCompatActivity() {
    lateinit var  bind : ActivityMainBinding
    private lateinit var userViewMOdel: UserViewMOdel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = DataBindingUtil.setContentView(this,R.layout.activity_main)

        //Room Database

        val dao= UserDataBase.getInstance(application).userDAO
        val repo = UserRepo(dao)
        val factory = UserViewModelFactory(repo)

        //connecting things togather

        userViewMOdel = ViewModelProvider(this,
        factory).get(UserViewMOdel::class.java)
        bind.userViewModel = userViewMOdel

        bind.lifecycleOwner = this


    }
    private fun initRecyclerView(){
        bind.recyclerView.layoutManager = LinearLayoutManager(this)

    }
    private fun display(){
        userViewMOdel.users.observe(this,
        Observer {
            bind.recyclerView.adapter = MyRecyclerView(
                it,{selectedItem: User -> listItemClicked(selectedItem)}
            )
        })
    }

    private fun listItemClicked(selectedItem: User) {

        Toast.makeText(this,
        "Selected name is ${selectedItem.name}",
        Toast.LENGTH_LONG).show()

        userViewMOdel.initUpdateAndDelete(selectedItem)
    }

}