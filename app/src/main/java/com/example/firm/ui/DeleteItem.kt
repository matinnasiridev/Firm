package com.example.firm.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.firm.databinding.FragmentDialogDeleteItemBinding
import com.example.firm.viewModel.MainViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.android.ext.android.inject


class DeleteItem : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentDialogDeleteItemBinding
    private val args by navArgs<DeleteItemArgs>()
    private val viewM: MainViewModel by inject()

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

        val str: (s: String) -> String = { "'$it'" }
        binding.apply {

            noteTitle.text = str(viewM.filterID(args.noteID).title!!)

            dismis.setOnClickListener { dismiss() }

            action.setOnClickListener {
                viewM.deleteItemByID(args.noteID)
                dismiss()
            }
        }
    }
}