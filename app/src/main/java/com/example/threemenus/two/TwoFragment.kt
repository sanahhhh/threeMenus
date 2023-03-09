package com.example.threemenus.two

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.example.threemenus.MainActivity
import com.example.threemenus.R
import com.example.threemenus.databinding.FragmentTwoBinding
import com.example.threemenus.detailed.FragmentDetailed

class TwoFragment : Fragment() {

    private lateinit var binding: FragmentTwoBinding
    private val viewModel by viewModels<TwoViewModel>()
    private val adapterTwo = TwoAdapter()

    companion object {
        val userTwo = "USER_TWO"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTwoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rwTwo.adapter = adapterTwo

        adapterTwo.setClickListener {user ->
            parentFragmentManager.commit {
                val args =
                    bundleOf(userTwo to user)
                val fragment = FragmentDetailed().apply {
                    arguments = args
                }

                replace(R.id.flContainer, fragment)
            }
        }

        viewModel.listUsersData.observe(viewLifecycleOwner) {
            it?.let { listTwo ->
                adapterTwo.setUsers(listTwo)
            }
        }

    }
}