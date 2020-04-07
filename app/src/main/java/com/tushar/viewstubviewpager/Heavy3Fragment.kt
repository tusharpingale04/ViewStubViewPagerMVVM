package com.tushar.viewstubviewpager

import android.os.Bundle
import com.tushar.viewstubviewpager.databinding.FragmentHeavyThreeBinding

class Heavy3Fragment : BaseViewStubFragment<FragmentHeavyThreeBinding,SharedViewModel>(SharedViewModel::class.java) {

    override fun getViewStubLayoutResource(): Int {
        return R.layout.fragment_heavy_three
    }

    override fun onCreateViewAfterViewStubInflated(binding: FragmentHeavyThreeBinding, viewModel: SharedViewModel, savedInstanceState: Bundle?) {
        binding.vm = viewModel
        binding.fragmentTitle.text = arguments!!["title"] as String
    }
}