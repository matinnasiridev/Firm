package com.example.firm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firm.databinding.FragmentAddNoteBinding
import com.example.firm.viewModel.MainViewModel
import org.koin.android.ext.android.inject

class AddNote : Fragment() {
    private lateinit var binding: FragmentAddNoteBinding
    private val viewM: MainViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentAddNoteBinding.inflate(LayoutInflater.from(inflater.context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set The Value ~> Done!
    }

}

