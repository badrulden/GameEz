package com.example.gameez

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.gameez.databinding.FragmentEndBinding

class EndFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        (activity as AppCompatActivity).supportActionBar?.title = "Finish"

       val binding: FragmentEndBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_end, container, false)

        var args = arguments?.let { EndFragmentArgs.fromBundle(it) }
        binding.explain.text = args?.result
        return binding.root
    }

}