package com.example.basepics.ui.pics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.basepics.R
import com.example.basepics.base.BaseFragment
import com.example.basepics.base.BaseViewModel
import com.example.basepics.databinding.PicsFragmentBinding
import com.example.basepics.extension.KEY
import com.example.basepics.ui.main.MainAdapter
import com.example.basepics.ui.main.MainViewModel

class PicsFragment : BaseFragment<PicsFragmentBinding, BaseViewModel>() {

    private val adapter = PicsAdapter()
    override val viewModel: PicsViewModel by lazy {
        ViewModelProvider(requireActivity())[PicsViewModel::class.java]
    }


    override fun inflateVB(layoutInflater: LayoutInflater): PicsFragmentBinding {
        return PicsFragmentBinding.inflate(layoutInflater)
    }

    override fun checkInternet() {
    }

    override fun initViews() {
        binding.recyclerResult.adapter = adapter
        binding.recyclerResult.layoutManager = GridLayoutManager(requireContext(), 3)
        val argument = arguments?.getStringArrayList(KEY)
        argument?.let { adapter.setList(it) }

    }

    override fun initViewModel() {
    }

    override fun initListener() {

    }


}