package com.example.firm.addNoteView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.firm.R
import com.example.firm.databinding.FragmentAddNoteBinding
import com.example.firm.util.showToast

class AddNoteFragment : Fragment() {
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

