package com.example.basepics.ui.pics

import android.view.LayoutInflater

import androidx.lifecycle.ViewModelProvider

import com.example.basepics.base.BaseFragment
import com.example.basepics.base.BaseViewModel
import com.example.basepics.databinding.PicsFragmentBinding
import com.example.basepics.extension.KEY

class PicsFragment : BaseFragment<PicsFragmentBinding, BaseViewModel>() {

    private val picsAdapter = PicsAdapter()
    override val viewModel: PicsViewModel by lazy {
        ViewModelProvider(requireActivity())[PicsViewModel::class.java]
    }

    override fun inflateVB(layoutInflater: LayoutInflater): PicsFragmentBinding {
        return PicsFragmentBinding.inflate(layoutInflater)
    }

    override fun checkInternet() {
    }

    override fun initViews() {
        binding.recyclerResult.adapter = picsAdapter
        val argument = arguments?.getStringArrayList(KEY)
        argument?.let { picsAdapter.setList(it) }
    }

    override fun initViewModel() {
    }

    override fun initListener() {

    }

    override fun onDestroy() {
        super.onDestroy()
        val argument = arguments?.getStringArrayList(KEY)
        argument?.clear()
    }


}