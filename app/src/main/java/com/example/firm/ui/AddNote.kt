package com.example.firm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firm.databinding.FragmentAddNoteBinding

class AddNote : Fragment() {
    private lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentAddNoteBinding.inflate(LayoutInflater.from(inflater.context), container, false)
        return binding.root
    }


}

