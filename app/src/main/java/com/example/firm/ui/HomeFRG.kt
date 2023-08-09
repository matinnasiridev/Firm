package com.example.firm.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.example.firm.R
import com.example.firm.adapter.CategoryAdapter
import com.example.firm.adapter.NotesAdapter
import com.example.firm.util.RecyclerCallBack
import com.example.firm.databinding.FragmentHomeBinding
import com.example.firm.model.CategoryData
import com.example.firm.model.SingleNoteData
import com.example.firm.util.setAdapter
import com.example.firm.viewModel.MainViewModel
import org.koin.android.ext.android.inject


class HomeFRG : Fragment(), RecyclerCallBack {
    private lateinit var binding: FragmentHomeBinding
    private val viewM: MainViewModel by inject()
    private lateinit var nAdapter: NotesAdapter
    private lateinit var cAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(
            LayoutInflater.from(layoutInflater.context),
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.window?.statusBarColor = ContextCompat.getColor(requireContext(), R.color.green)
        initUI()
    }


    private fun initUI() {
        btnAddNote()
        fillAdapters()
        search()
        loadItems()
        refresh()
    }

    private fun search() {
        binding.apply {
            edtsearch.addTextChangedListener {
                viewM.filterName(it.toString()).observe(requireActivity()) { target ->
                    if (target.isNotEmpty())
                        nAdapter.submit(target)
                }
                // Clean Button
                btnclean.isVisible = it?.isNotEmpty() == true
                btnclean.setOnClickListener { edtsearch.setText("") }
                // -->
            }
        }
    }

    private fun fillAdapters() {
        nAdapter = NotesAdapter(api = this)
        cAdapter = CategoryAdapter()
    }

    private fun loadItems() {
        binding.apply {
            rcCategory.setAdapter(true) { cAdapter }
            rcNote.setAdapter { nAdapter }
        }
    }

    private fun refresh() {
        viewM.getAllNotes().observe(requireActivity()) {
            if (it.isNotEmpty()) {
                nAdapter.submit(it)
                binding.apply {
                    rcNote.isVisible = true
                    imgRecycler.isVisible = false
                }
            }
        }
    }


    private fun btnAddNote() {
        binding.action.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addNoteFragment)
        }
    }

    override fun onClick(noteID: Long) {
        findNavController().navigate(
            HomeFRGDirections.actionHomeFragmentToShowNoteFragment(
                noteID
            )
        )
    }

    override fun onLongClick(noteID: Long) {
        findNavController().navigate(
            HomeFRGDirections.actionHomeFragmentToDialogDeleteItem(
                noteID
            )
        )
    }
}