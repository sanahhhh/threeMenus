package com.example.threemenus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.threemenus.databinding.ActivityMainBinding
import com.example.threemenus.one.OneFragment
import com.example.threemenus.two.TwoFragment
import com.github.javafaker.Faker

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val faker = Faker.instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonOne.setOnClickListener {
           setTransactionFragment(OneFragment())
        }

        binding.buttonTwo.setOnClickListener {
            setTransactionFragment(TwoFragment())
        }
    }

    private fun setTransactionFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.flContainer, fragment)
        }
    }

}