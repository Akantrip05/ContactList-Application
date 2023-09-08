package com.udemy.contactapplication.UI

import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.udemy.contactapplication.R
import com.udemy.contactapplication.databinding.CardViewBinding
import com.udemy.contactapplication.room.User

class MyRecyclerView(private var usersList: List<User>,
private val clickListener: (User)-> Unit):RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding:CardViewBinding =
            DataBindingUtil.
            inflate(
            layoutInflater,
            R.layout.card_view,
            parent,
            false
       )
           return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(usersList[position],clickListener)

    }

    override fun getItemCount(): Int {
        return usersList.size
    }


}
class MyViewHolder(val binding: CardViewBinding):RecyclerView.ViewHolder(binding.root){
fun bind(user: User,
clickListener: (User) -> Unit){
    binding.cardText1.text = user.name
    binding.cardtext2.text = user.email

    binding.listMode.setOnClickListener(){
        clickListener(user)
    }
}
}