package com.example.firm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.navArgs
import com.example.firm.databinding.FragmentAddNoteBinding
import com.example.firm.model.SingleNoteData
import com.example.firm.util.onBack
import com.example.firm.util.showToast
import com.example.firm.viewModel.MainViewModel
import org.koin.android.ext.android.inject
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddNote : Fragment() {
    private lateinit var binding: FragmentAddNoteBinding
    private val viewM: MainViewModel by inject()
    private val args by navArgs<AddNoteArgs>()
    private var ed: SingleNoteData? = null
    private val date = Calendar.getInstance().time

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentAddNoteBinding.inflate(LayoutInflater.from(inflater.context), container, false)
        return binding.root
    }

    @Suppress("DEPRECATION")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ed = if (args.noteID != -99999L) viewM.filterID(args.noteID) else null

        initUIForEdit()

        initUIInDataBase {
            onSaveClick()
            requireActivity().onBackPressed()
        }


    }

    private fun initUIForEdit() {
        if (ed != null) {
            binding.apply {
                tvDate.text = ed!!.createDate
                edtTitle.setText(ed!!.title)
                edtDetail.setText(ed!!.main)
            }
        }
    }

    private fun initUIInDataBase(onSavePress: () -> Unit) {
        binding.apply {
            btnBack.onBack(requireActivity())

            tvDate.text = month().format(date).toString()

            edtTitle.addTextChangedListener {
                tvNumberCount.text = (30 - edtTitle.length()).toString()
            }

            save.setOnClickListener {
                if (edtTitle.text.isNotEmpty() && edtDetail.text.isNotEmpty())
                    onSavePress()
                else
                    requireActivity().showToast("PorKon BiSahabo!")
            }
        }
    }

    private fun onSaveClick() {
        binding.apply {
            if (ed == null) {
                viewM.insertNote(
                    SingleNoteData(
                        title = edtTitle.text.toString(),
                        main = edtDetail.text.toString(),
                        createDate = year().format(date).toString(),
                        lastUpdateDate = month().format(date).toString()
                    )
                )
            } else {
                viewM.insertNote(
                    SingleNoteData(
                        id = ed!!.id,
                        title = edtTitle.text.toString(),
                        main = edtDetail.text.toString(),
                        createDate = ed!!.createDate,
                        lastUpdateDate = month().format(date).toString(),
                    )
                )
            }
        }
    }

    private val month: () -> SimpleDateFormat = {
        SimpleDateFormat("dd MMM", Locale.getDefault())
    }
    private val year: () -> SimpleDateFormat = {
        SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
    }
}

