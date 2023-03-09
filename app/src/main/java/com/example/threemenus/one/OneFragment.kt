package com.example.threemenus.one

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels

import com.example.threemenus.databinding.FragmentOneBinding

class OneFragment : Fragment() {

    private lateinit var binding: FragmentOneBinding
    private val viewModel by viewModels<OneViewModel>()
    private val adapterOne = OneAdapter()

    //Создаем фрагмент
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentOneBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvOne.adapter = adapterOne

        viewModel.listUsersData.observe(viewLifecycleOwner) {
            it?.let { list ->
                adapterOne.setUsers(list)
            }
        }
    }

}