package com.example.threemenus.two

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.threemenus.databinding.ItemUserBinding

class TwoAdapter: RecyclerView.Adapter<TwoAdapter.MyViewHolder>() {

    private var users: List<TwoViewModel.User> = emptyList()

    private var onClickListener: ((TwoViewModel.User) -> Unit)? = null

    fun setClickListener(action: ((TwoViewModel.User) -> Unit)) {
        onClickListener = action
    }

    fun setUsers(users: List<TwoViewModel.User>) {
        this.users = users
    }


    class MyViewHolder(
        val binding: ItemUserBinding, val onClickListener: ((TwoViewModel.User) -> Unit)?) : RecyclerView.ViewHolder(binding.root){
        fun bind(user:TwoViewModel.User) {
            binding.userNameTextView.text = user.name
            binding.userCompanyTextView.text = user.company
            binding.root.setOnClickListener{
                onClickListener?.invoke(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return MyViewHolder(binding, onClickListener)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(users[position])

    }

    override fun getItemCount() = users.size

}