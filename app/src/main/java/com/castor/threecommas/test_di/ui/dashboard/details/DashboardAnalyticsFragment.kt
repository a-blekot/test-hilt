package com.castor.threecommas.test_di.ui.dashboard.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.castor.threecommas.test_di.databinding.FragmentDashboardAnalyticsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardAnalyticsFragment : Fragment() {

    private val viewModel: DashboardAnalyticsViewModel by activityViewModels()
    private val viewModelShared: DashboardDetailsViewModel by viewModels()//{ requireParentFragment() }
    private var _binding: FragmentDashboardAnalyticsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentDashboardAnalyticsBinding.inflate(inflater, container, false).also {
            _binding = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.dashboardAnalyticsRepoInfo.text = viewModelShared.text
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}