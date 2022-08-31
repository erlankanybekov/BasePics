package com.example.basepics.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding
import com.example.basepics.R

abstract class BaseFragment<VB: ViewBinding,VM: BaseViewModel>:Fragment(){

    protected lateinit var binding: VB
    protected abstract val viewModel: VM
    private var navController:NavController?=null

    protected abstract fun inflateVB(layoutInflater: LayoutInflater):VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateVB(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       val navHost = activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        navController = navHost.navController
        checkInternet()
        initViews()
        initViewModel()
        initListener()
    }
    fun setNavigate(direction:Int,data:Bundle?){
        navController?.navigate(direction,data)

    }

    fun getBundle(key:String){
        val bundle = Bundle()
        bundle.getStringArrayList(key)
    }

    abstract fun checkInternet()
    abstract fun initViews()
    abstract fun initViewModel()
    abstract fun initListener()
}