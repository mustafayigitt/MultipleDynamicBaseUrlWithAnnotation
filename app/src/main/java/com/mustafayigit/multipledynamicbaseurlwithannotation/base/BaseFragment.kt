package com.mustafayigit.multipledynamicbaseurlwithannotation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding


/**
 * Created by Mustafa Yiğit on 24/11/2022
 * mustafa.yt65@gmail.com
 */
abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel> : Fragment() {

    protected var mBinding: VB? = null
    protected var mViewModel: VM? = null

    abstract fun bindingInflater(): (LayoutInflater) -> VB
    abstract fun getViewModelClass(): Class<VM>

    abstract fun initObserver(binding: VB, viewModel: VM)
    abstract fun initListener(binding: VB, viewModel: VM)

    abstract fun onViewReady(binding: VB, viewModel: VM)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = bindingInflater().invoke(inflater)
        mViewModel = ViewModelProvider(this)[getViewModelClass()]
        initObserver(mBinding!!, mViewModel!!)
        initListener(mBinding!!, mViewModel!!)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewReady(mBinding!!, mViewModel!!)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}