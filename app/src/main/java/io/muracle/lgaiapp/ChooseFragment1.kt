package io.muracle.lgaiapp

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
import io.muracle.lgaiapp.databinding.FragmentChoose1Binding
import io.muracle.lgaiapp.utils.Constants
import io.muracle.lgaiapp.utils.PAGE
import java.util.*
import kotlin.collections.ArrayList


class ChooseFragment1 : Fragment() {
    private lateinit var viewModel: MainViewModel
    private var _binding: FragmentChoose1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(Constants.TAG, "ChooseFragment1 onCreateView")

        _binding = FragmentChoose1Binding.inflate(inflater, container, false)
        activity?.let {
            viewModel = ViewModelProvider(it).get(MainViewModel::class.java)
            viewModel.currentDestination.value = PAGE.CHOOSE1
            binding.viewModel = viewModel
            binding.lifecycleOwner = this
        }


        val items = ArrayList<CheckItem>()

        items.add(CheckItem(1,"ThinQ 3.5", false))
        items.add(CheckItem(2,"LGE.com", false))
        items.add(CheckItem(3,"Best shop", false))
        items.add(CheckItem(4,"B2B", false))

        val adapter = RadioViewAdapter(items, viewModel.selected_choose_1) { _, pos ->
            var selectItem = items[pos]
            viewModel.selected_choose_1 = selectItem.id

            Log.i(Constants.TAG, selectItem.toString())
        }


        val gridLayoutManager = GridLayoutManager(context, 2)
        binding.list.addItemDecoration(SpacesItemDecoration(Constants.pxTodp(20f, resources), Constants.pxTodp(20f, resources)))
        binding.list.layoutManager = gridLayoutManager
        binding.list.adapter = adapter

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.choose1To2)
        }




        return binding.root
    }


}