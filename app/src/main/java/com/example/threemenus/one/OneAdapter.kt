package com.example.threemenus.one

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.threemenus.R

class OneAdapter: RecyclerView.Adapter<OneAdapter.MyViewHolder>() {

    private var users: List<OneViewModel.User> = emptyList()

    fun setUsers(users: List<OneViewModel.User>) {
        this.users = users
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val userNameTextView: TextView = itemView.findViewById(R.id.userNameTextView)
        val userCompanyTextView: TextView = itemView.findViewById(R.id.userCompanyTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_user, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.userNameTextView.text = users[position].name
        holder.userCompanyTextView.text = users[position].company
    }

    override fun getItemCount() = users.size
}