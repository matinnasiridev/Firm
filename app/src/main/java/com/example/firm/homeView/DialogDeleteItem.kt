package com.example.firm.homeView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.firm.databinding.FragmentDialogDeleteItemBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class DialogDeleteItem : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentDialogDeleteItemBinding
    private val args by navArgs<DialogDeleteItemArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDialogDeleteItemBinding.inflate(
            LayoutInflater.from(inflater.context),
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.noteTitle.text = args.note.title
        binding.dismis.setOnClickListener { dismiss() }
        binding.action.setOnClickListener {
            // TODO Remove The note From Room And Send Event To HomeFrg


            dismiss()
        }
    }
}

