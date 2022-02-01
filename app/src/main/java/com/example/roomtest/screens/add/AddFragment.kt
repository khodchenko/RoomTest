package com.example.roomtest.screens.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.roomtest.APP
import com.example.roomtest.R
import com.example.roomtest.databinding.FragmentAddBinding
import com.example.roomtest.model.NoteModel

class AddFragment : Fragment() {

    lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(AddViewModel::class.java)
        binding.btnAddNote.setOnClickListener {
            val title = binding.etAddTitle.text.toString()
            val titleDescription = binding.etAddDescription.text.toString()
            viewModel.insert(NoteModel(title=title, description = titleDescription)){}
            APP.navController.navigate(R.id.action_addFragment_to_startFragment)
        }
        binding.btnAddnoteBack.setOnClickListener{
            APP.navController.navigate(R.id.action_addFragment_to_startFragment)
        }

    }


}