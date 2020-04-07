package com.tushar.viewstubviewpager

import android.view.ViewStub
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ProgressBar
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseViewStubFragment<Binding: ViewDataBinding, VM: ViewModel>(private val mViewModelClass: Class<VM>): Fragment() {
    private var mSavedInstanceState: Bundle? = null
    private var hasInflated = false
    private var mViewStub: ViewStub? = null
    private var isFragmentVisible = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_viewstub, container, false)
        mViewStub = view.findViewById(R.id.fragmentViewStub) as ViewStub
        mViewStub!!.layoutResource = getViewStubLayoutResource()
        mSavedInstanceState = savedInstanceState

        if (isFragmentVisible && !hasInflated) {
            val inflatedView = mViewStub!!.inflate()
            val binding = DataBindingUtil.bind<Binding>(inflatedView)
            binding?.lifecycleOwner = this
            val viewModel = activity?.run {
                ViewModelProvider(this).get(mViewModelClass)
            }
            onCreateViewAfterViewStubInflated(binding!!,viewModel!!, mSavedInstanceState)
            afterViewStubInflated(view)
        }

        return view
    }

    protected abstract fun onCreateViewAfterViewStubInflated(binding: Binding, viewModel: VM, savedInstanceState: Bundle?)

    @LayoutRes
    protected abstract fun getViewStubLayoutResource(): Int

    @CallSuper
    protected fun afterViewStubInflated(originalViewContainerWithViewStub: View?) {
        hasInflated = true
        if (originalViewContainerWithViewStub != null) {
            val pb = originalViewContainerWithViewStub.findViewById<ProgressBar>(R.id.inflateProgressbar)
            pb.visibility = View.GONE
        }
    }

    override fun onPause() {
        super.onPause()
        isFragmentVisible = false
        setFragmentVisibility(isFragmentVisible)
    }

    override fun onResume() {
        super.onResume()
        isFragmentVisible = true
        setFragmentVisibility(isFragmentVisible)
    }

    private fun setFragmentVisibility(isVisibleToUser: Boolean) {
        if (isVisibleToUser && mViewStub != null && !hasInflated) {
            val inflatedView = mViewStub!!.inflate()
            val binding = DataBindingUtil.bind<Binding>(inflatedView)
            binding?.lifecycleOwner = this
            val viewModel = activity?.run {
                ViewModelProvider(this).get(mViewModelClass)
            }
            onCreateViewAfterViewStubInflated(binding!!,viewModel!!, mSavedInstanceState)
            afterViewStubInflated(view)
        }
    }

    override fun onDetach() {
        super.onDetach()
        hasInflated = false
    }
}