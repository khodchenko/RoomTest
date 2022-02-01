package com.example.roomtest.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.roomtest.APP
import com.example.roomtest.R
import com.example.roomtest.adapter.NoteAdapter
import com.example.roomtest.databinding.FragmentStartBinding
import com.example.roomtest.model.NoteModel

class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        viewModel.innitDataBase()
        recyclerView = binding.recyclerView
        adapter = NoteAdapter()
        recyclerView.adapter = adapter
        viewModel.getAllNotes().observe(viewLifecycleOwner, {listNotes ->
            adapter.setList(listNotes.asReversed())
        })

        binding.bntNext.setOnClickListener {
            APP.navController.navigate(R.id.action_startFragment_to_addFragment)
        }
    }

    companion object {
        fun clickNote(noteModel:NoteModel){
            val bundle = Bundle()
            bundle.putSerializable("note", noteModel)
            APP.navController.navigate(R.id.action_startFragment_to_detailFragment, bundle)
        }

    }

}