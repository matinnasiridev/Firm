package com.example.firm.homeView


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.firm.R
import com.example.firm.databinding.FragmentHomeBinding
import com.example.firm.model.Repository
import com.example.firm.model.SingleNoteData
import com.example.firm.util.setAdapter


class HomeFragment : Fragment(), RecyclerCallBack<SingleNoteData> {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(
            LayoutInflater.from(layoutInflater.context),
            container,
            false
        )
        binding.action.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addNoteFragment)
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerMain.setAdapter {
            MainRecyclerAdapter(
                Repository().createFakeData(),
                this
            )
        }

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

    override fun onClick(note: SingleNoteData) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToShowNoteFragment(
                note
            )
        )
    }

    override fun onLongClick(note: SingleNoteData) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToDialogDeleteItem(
                note
            )
        )
    }

}
