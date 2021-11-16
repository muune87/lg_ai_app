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
import io.muracle.lgaiapp.databinding.FragmentChoose6Binding
import io.muracle.lgaiapp.utils.Constants
import io.muracle.lgaiapp.utils.PAGE
import java.util.*
import kotlin.collections.ArrayList


class ChooseFragment6 : Fragment() {
    private lateinit var viewModel: MainViewModel
    private var _binding: FragmentChoose6Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(Constants.TAG, "ChooseFragment6 onCreateView")

        _binding = FragmentChoose6Binding.inflate(inflater, container, false)
        activity?.let {
            viewModel = ViewModelProvider(it).get(MainViewModel::class.java)
            viewModel.currentDestination.value = PAGE.CHOOSE6
            binding.viewModel = viewModel
            binding.lifecycleOwner = this
        }

        val items = ArrayList<CheckItem>()

        items.add(CheckItem(1,"타워에어컨", false))
        items.add(CheckItem(2,"시스템 에어컨", false))
        items.add(CheckItem(3,"상업용 시스템 에어컨", false))
        items.add(CheckItem(4,"벽걸이 에어컨", false))

        val adapter = RadioViewAdapter(items, viewModel.selected_choose_6) { _, pos ->
            var selectItem = items[pos]
            viewModel.selected_choose_6 = selectItem.id
            Log.i(Constants.TAG, selectItem.toString())
        }

        val gridLayoutManager = GridLayoutManager(context, 2)
        binding.list.addItemDecoration(SpacesItemDecoration(Constants.pxTodp(20f, resources), Constants.pxTodp(20f, resources)))
        binding.list.layoutManager = gridLayoutManager
        binding.list.adapter = adapter

        binding.btnPrev.setOnClickListener {
            findNavController().navigate(R.id.choose6To5)
        }

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.choose6To7)
        }

        return binding.root
    }
}
