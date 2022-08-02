package com.example.rickymorty

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rickymorty.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private lateinit var bundle: Bundle
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvName = arguments?.getString(MainFragment.KFN)
        val tvLife = arguments?.getString(MainFragment.KFL)
        val tvPicture = arguments?.getString(MainFragment.KFP)
        binding.tvName.text = tvName
        binding.tvLife.text = tvLife
        tvPicture?.let {
            binding.ivPicture.loadWithGlide(it)
        }
    }
}