package com.example.firm.showNote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firm.MainView.Companion.TAG
import com.example.firm.R
import com.example.firm.databinding.FragmentShowNoteBinding
import com.example.firm.model.SingleNoteData
import com.example.firm.util.showToast

class ShowNoteFragment : Fragment() {
    private lateinit var binding: FragmentShowNoteBinding
    private lateinit var note: SingleNoteData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShowNoteBinding.inflate(
            LayoutInflater.from(inflater.context),
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        note = requireArguments().getParcelable(TAG)!!

        binding.textTitle.text = note.title
    }
}