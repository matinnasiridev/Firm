package com.example.firm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
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
    private val date = Calendar.getInstance().time

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

        init {
            val year = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
            binding.apply {
                viewM.insertNote(
                    SingleNoteData(
                        title = edtTitle.text.toString(),
                        main = edtDetail.text.toString(),
                        lastUpdateDate = year.format(date).toString()
                    )
                )
            }
            requireActivity().onBackPressed()
        }


    }

    private fun init(onSavePress: () -> Unit) {
        binding.apply {
            btnBack.onBack(requireActivity())

            val df = SimpleDateFormat("dd MMM", Locale.getDefault())
            tvDate.text = df.format(date).toString()

            edtTitle.addTextChangedListener {
                tvNumberCount.text = (35 - edtTitle.length()).toString()
            }

            save.setOnClickListener {
                if (edtTitle.text.isNotEmpty() && edtDetail.text.isNotEmpty())
                    onSavePress()
                else
                    requireActivity().showToast("PorKon Bi sahabo!")
            }
        }
    }
}

