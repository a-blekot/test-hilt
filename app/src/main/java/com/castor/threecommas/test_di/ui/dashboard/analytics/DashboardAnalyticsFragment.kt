package com.castor.threecommas.test_di.ui.dashboard.analytics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navGraphViewModels
import com.castor.threecommas.test_di.R
import com.castor.threecommas.test_di.databinding.FragmentDashboardAnalyticsBinding
import com.castor.threecommas.test_di.ui.dashboard.details.DashboardDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardAnalyticsFragment : Fragment() {


    private val viewModelShared: DashboardDetailsViewModel by navGraphViewModels(R.id.root_navigation_graph) {
        defaultViewModelProviderFactory
    }
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