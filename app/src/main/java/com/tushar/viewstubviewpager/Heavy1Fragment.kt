package com.tushar.viewstubviewpager

import android.os.Bundle
import com.tushar.viewstubviewpager.databinding.FragmentHeavyOneBinding

class Heavy1Fragment : BaseViewStubFragment<FragmentHeavyOneBinding,SharedViewModel>(SharedViewModel::class.java) {

    override fun getViewStubLayoutResource(): Int {
        return R.layout.fragment_heavy_one
    }

    override fun onCreateViewAfterViewStubInflated(binding: FragmentHeavyOneBinding, viewModel: SharedViewModel, savedInstanceState: Bundle?) {
        binding.vm = viewModel
        binding.fragmentTitle.text = arguments!!["title"] as String
    }
}