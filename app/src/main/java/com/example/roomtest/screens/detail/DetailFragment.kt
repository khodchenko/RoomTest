package com.example.roomtest.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.example.roomtest.APP
import com.example.roomtest.R
import com.example.roomtest.databinding.FragmentDetailBinding
import com.example.roomtest.databinding.FragmentStartBinding
import com.example.roomtest.model.NoteModel
import com.example.roomtest.screens.start.StartFragment


class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    private lateinit var currentNote: NoteModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        currentNote = arguments?.getSerializable("note") as NoteModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        binding.tvTitleDetail.text = currentNote.title
        binding.tvDescriptionDetail.text = currentNote.description

        view?.findViewById<Button>(R.id.btn_detail_delete)?.setOnClickListener {
            viewModel.delete(currentNote){}
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }

        binding.btnDescriptionBack.setOnClickListener {
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }


    }


}