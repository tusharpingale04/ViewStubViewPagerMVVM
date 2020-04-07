package com.tushar.viewstubviewpager

import android.os.Bundle
import com.tushar.viewstubviewpager.databinding.FragmentHeavyTwoBinding

class Heavy2Fragment : BaseViewStubFragment<FragmentHeavyTwoBinding,SharedViewModel>(SharedViewModel::class.java) {

    override fun getViewStubLayoutResource(): Int {
        return R.layout.fragment_heavy_two
    }

    override fun onCreateViewAfterViewStubInflated(binding: FragmentHeavyTwoBinding, viewModel: SharedViewModel, savedInstanceState: Bundle?) {
        binding.vm = viewModel
        binding.fragmentTitle.text = arguments!!["title"] as String
    }
}