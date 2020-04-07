package com.tushar.viewstubviewpager

import android.os.Bundle
import com.tushar.viewstubviewpager.databinding.FragmentHeavyFourBinding

class Heavy4Fragment : BaseViewStubFragment<FragmentHeavyFourBinding,SharedViewModel>(SharedViewModel::class.java) {

    override fun getViewStubLayoutResource(): Int {
        return R.layout.fragment_heavy_four
    }

    override fun onCreateViewAfterViewStubInflated(binding: FragmentHeavyFourBinding, viewModel: SharedViewModel, savedInstanceState: Bundle?) {
        binding.vm = viewModel
        binding.fragmentTitle.text = arguments!!["title"] as String
    }
}