package com.example.firm.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.firm.R
import com.example.firm.adapter.MainRecyclerAdapter
import com.example.firm.util.RecyclerCallBack
import com.example.firm.databinding.FragmentHomeBinding
import com.example.firm.model.SingleNoteData
import com.example.firm.util.setAdapter
import com.example.firm.viewModel.MainViewModel
import org.koin.android.ext.android.inject


class HomeFRG : Fragment(), RecyclerCallBack<SingleNoteData> {
    private lateinit var binding: FragmentHomeBinding
    private val viewM: MainViewModel by inject()
    private lateinit var mAdapter: MainRecyclerAdapter

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

        viewM.getAllNotes().observe(requireActivity()) { mAdapter.refreshRecycler(it) }

        mAdapter = MainRecyclerAdapter(api = this)

        // Ui Handeler TODO Search Handeler!
        showRecycler()
        searchHandeler()
        btnAddNote()

    }

    private fun btnAddNote() {
        binding.action.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addNoteFragment)
        }
    }

    private fun searchHandeler() {
        binding.toolBar.apply {
            btnSearch.setOnClickListener {
                btnSearch.isVisible = false
                btnClose.isVisible = true
                searchData.visibility = View.VISIBLE
            }
            btnClose.setOnClickListener {
                btnSearch.isVisible = true
                btnClose.isVisible = false
                searchData.visibility = View.INVISIBLE
            }
        }
    }

    private fun showRecycler() = binding.recyclerMain.setAdapter { mAdapter }

    override fun onClick(note: SingleNoteData) {
        findNavController().navigate(
            HomeFRGDirections.actionHomeFragmentToShowNoteFragment(
                note
            )
        )
    }

    override fun onLongClick(note: SingleNoteData) {
        findNavController().navigate(
            HomeFRGDirections.actionHomeFragmentToDialogDeleteItem(
                note
            )
        )
    }

}