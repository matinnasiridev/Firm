package com.example.firm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.firm.databinding.FragmentShowNoteBinding
import com.example.firm.model.SingleNoteData
import com.example.firm.util.onBack
import com.example.firm.viewModel.MainViewModel
import org.koin.android.ext.android.inject

class ShowNote : Fragment() {
    private lateinit var binding: FragmentShowNoteBinding
    private val viewM: MainViewModel by inject()
    private val args by navArgs<ShowNoteArgs>()
    private lateinit var nd: SingleNoteData

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
        nd = viewM.filterID(args.noteID)
        initUI { onEditClick() }
    }

    private fun onEditClick(){
        findNavController().navigate(
            ShowNoteDirections.actionShowNoteFragmentToAddNoteFragment(
                args.noteID
            )
        )
    }
    private fun initUI(onEditClick: () -> Unit) {
        binding.apply {
            btnBack.onBack(requireActivity())
            tvDate.text = nd.lastUpdateDate
            tvTitle.text = nd.title
            tvDetail.text = nd.main
            edit.setOnClickListener { onEditClick() }
        }
    }
}