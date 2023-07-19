package com.example.firm.ui


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.firm.R
import com.example.firm.adapter.MainRecyclerAdapter
import com.example.firm.adapter.RecyclerCallBack
import com.example.firm.databinding.FragmentHomeBinding
import com.example.firm.model.EventBounds
import com.example.firm.repository.Repository
import com.example.firm.model.SingleNoteData
import com.example.firm.util.Constants.TAG
import com.example.firm.util.FragmentEvent
import com.example.firm.util.setAdapter
import com.example.firm.util.showToast
import com.example.firm.viewModel.HomeViewModel
import org.koin.android.ext.android.inject


class HomeFRG : Fragment(), RecyclerCallBack<SingleNoteData>, FragmentEvent {
    private lateinit var binding: FragmentHomeBinding
    private val viewM: HomeViewModel by inject()

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


        showRecycler()

        searchNav()

        binding.action.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addNoteFragment)
        }

    }

    private fun searchNav() {
        val toolBar = binding.toolBar
        toolBar.btnSearch.setOnClickListener {
            toolBar.btnSearch.isVisible = false
            toolBar.btnClose.isVisible = true
            toolBar.searchData.visibility = View.VISIBLE
        }
        toolBar.btnClose.setOnClickListener {
            toolBar.btnSearch.isVisible = true
            toolBar.btnClose.isVisible = false
            toolBar.searchData.visibility = View.INVISIBLE
        }
    }

    private fun showRecycler() {
        binding.recyclerMain.setAdapter {
            MainRecyclerAdapter(
                viewM.getList(),
                this
            )
        }
    }

    override fun onRefresh() {
        showRecycler()
    }

    override fun onResume() {
        super.onResume()
        showRecycler()
    }

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
                note, EventBounds { this }
            )
        )
    }

}
