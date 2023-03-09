package com.example.threemenus.two

import android.os.Parcelable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.threemenus.one.OneViewModel
import com.github.javafaker.Faker
import kotlinx.parcelize.Parcelize

class TwoViewModel:ViewModel() {

    val listTwo:MutableList<User> = mutableListOf()
    val faker = Faker.instance()
    val listUsersData: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>(emptyList())
    }

    init {
        for (i in 0..100) {
            listTwo.add(User("${faker.name().name()} $i", "${faker.company().name()} $i"))
        }

        listUsersData.value = listTwo
    }


    @Parcelize
    data class User(val name: String, val company: String) : Parcelable

}