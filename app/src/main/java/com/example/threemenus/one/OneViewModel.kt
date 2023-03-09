package com.example.threemenus.one

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.javafaker.Faker

class OneViewModel : ViewModel() {

    val list:MutableList<User> = mutableListOf()
    val faker = Faker.instance()
    val listUsersData: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>(emptyList())
    }

    init {
        for (i in 0..100) {
            list.add(User("${faker.name().name()} $i","${faker.company().name()} $i"))
        }

        listUsersData.value = list
    }

    data class User(
        val name: String,
        val company: String
    )

}