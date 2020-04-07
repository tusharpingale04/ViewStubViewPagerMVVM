package com.tushar.viewstubviewpager

import android.os.Bundle
import com.tushar.viewstubviewpager.databinding.FragmentHeavyFiveBinding

class Heavy5Fragment : BaseViewStubFragment<FragmentHeavyFiveBinding,SharedViewModel>(SharedViewModel::class.java) {

    override fun getViewStubLayoutResource(): Int {
        return R.layout.fragment_heavy_five
    }

    override fun onCreateViewAfterViewStubInflated(binding: FragmentHeavyFiveBinding, viewModel: SharedViewModel, savedInstanceState: Bundle?) {
        binding.vm = viewModel
        binding.fragmentTitle.text = arguments!!["title"] as String
    }
}