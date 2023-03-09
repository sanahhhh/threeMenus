package com.example.threemenus.detailed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.threemenus.databinding.FragmentFourDetailedBinding
import com.example.threemenus.two.TwoFragment
import com.example.threemenus.two.TwoViewModel

class FragmentDetailed : Fragment() {

    private lateinit var binding: FragmentFourDetailedBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFourDetailedBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user = arguments?.getParcelable<TwoViewModel.User>(TwoFragment.userTwo)
        user?.let {
            binding.userNameTextView.text = it.name
            binding.userCompanyTextView.text = it.company
        }
    }
}