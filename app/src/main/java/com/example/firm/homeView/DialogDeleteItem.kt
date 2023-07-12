package com.example.firm.homeView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firm.MainView.Companion.TAG
import com.example.firm.R
import com.example.firm.databinding.FragmentDialogDeleteItemBinding
import com.example.firm.model.SingleNoteData
import com.example.firm.util.showToast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class DialogDeleteItem : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentDialogDeleteItemBinding
    private lateinit var note: SingleNoteData

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
        note = requireArguments().getParcelable(TAG)!!

        binding.noteTitle.text = "'${note.title}'"

        binding.dismis.setOnClickListener { dismiss() }
        binding.action.setOnClickListener {
            // TODO Remove The note From Room And Send Event To HomeFrg


            context?.showToast("Done")
            dismiss()

        }
    }
}

