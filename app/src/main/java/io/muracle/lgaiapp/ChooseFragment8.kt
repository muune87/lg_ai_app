package io.muracle.lgaiapp

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.util.Log
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import io.muracle.lgaiapp.adapter.RadioViewAdapter
import io.muracle.lgaiapp.adapter.SpacesItemDecoration
import io.muracle.lgaiapp.adapter.item.CheckItem
import io.muracle.lgaiapp.databinding.FragmentChoose8Binding
import io.muracle.lgaiapp.utils.Constants
import io.muracle.lgaiapp.utils.PAGE
import java.util.*
import kotlin.collections.ArrayList


class ChooseFragment8 : Fragment() {
    private lateinit var viewModel: MainViewModel
    private var _binding: FragmentChoose8Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(Constants.TAG, "ChooseFragment8 onCreateView")

        _binding = FragmentChoose8Binding.inflate(inflater, container, false)
        activity?.let {
            viewModel = ViewModelProvider(it).get(MainViewModel::class.java)
            viewModel.currentDestination.value = PAGE.CHOOSE8
            binding.viewModel = viewModel
            binding.lifecycleOwner = this
        }

        val items = ArrayList<CheckItem>()

        items.add(CheckItem(1,"스틱 청소기", false))
        items.add(CheckItem(2,"로봇 청소기 R9", false))
        items.add(CheckItem(3,"로봇 청소기", false))
        items.add(CheckItem(4,"물걸레 청소기", false))

        val adapter = RadioViewAdapter(items, viewModel.selected_choose_8) { _, pos ->
            var selectItem = items[pos]
            viewModel.selected_choose_8 = selectItem.id
            Log.i(Constants.TAG, selectItem.toString())
        }

        val gridLayoutManager = GridLayoutManager(context, 2)
        binding.list.addItemDecoration(SpacesItemDecoration(Constants.pxTodp(20f, resources), Constants.pxTodp(20f, resources)))
        binding.list.layoutManager = gridLayoutManager
        binding.list.adapter = adapter

        binding.btnPrev.setOnClickListener {
            findNavController().navigate(R.id.choose8To7)
        }

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.choose8To9)
        }

        return binding.root
    }
}