package com.example.firm.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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


class HomeFRG : Fragment(), RecyclerCallBack<SingleNoteData> {
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

        nAdapter = NotesAdapter(api = this)
        cAdapter = CategoryAdapter()

        /**
         * Test cAdapter
         */
        val fakeData = listOf(
            CategoryData(title = "one"),
            CategoryData(title = "two"),
            CategoryData(title = "th"),
            CategoryData(title = "fo"),
            CategoryData(title = "fi"),
            CategoryData(title = "se"),
            CategoryData(title = "sev"),
            CategoryData(title = "eg"),
            CategoryData(title = "ni"),
            CategoryData(title = "ten")
        )


        cAdapter.submit(fakeData)

        // Ui Handeler TODO Search Handeler!
        loadItems()
        btnAddNote()
        refresh()

    }

    private val refresh: () -> Unit = {
        viewM.getAllNotes().observe(requireActivity()) {
            if (it.isNotEmpty())
                nAdapter.refreshRecycler(it)
            else
                viewM.fillFirst()
        }
    }

    private fun btnAddNote() {
        binding.action.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addNoteFragment)
        }
    }


    private fun loadItems() {
        binding.apply {
            //Category
            rcCategory.setAdapter(true) { cAdapter }
            // Note
            rcNote.setAdapter { nAdapter }
        }
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
                note
            )
        )
    }
}