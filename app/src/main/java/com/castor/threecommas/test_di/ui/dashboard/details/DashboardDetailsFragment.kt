package com.castor.threecommas.test_di.ui.dashboard.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.castor.threecommas.test_di.R
import com.castor.threecommas.test_di.databinding.FragmentDashboardDetailsBinding
import com.castor.threecommas.test_di.ui.dashboard.details.DashboardDetailsFragmentDirections.Companion.toDashboardAnalytics
import com.castor.threecommas.test_di.ui.dashboard.details.DashboardDetailsFragmentDirections.Companion.toLogin
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardDetailsFragment : Fragment() {

    private val viewModelShared: DashboardDetailsViewModel by navGraphViewModels(R.id.root_navigation_graph) {
        defaultViewModelProviderFactory
    }

    private var _binding: FragmentDashboardDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentDashboardDetailsBinding.inflate(inflater, container, false).also {
            _binding = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.run {
            dashboardDetailsRepoInfo.text = viewModelShared.text

            dashboardDetailsButton.setOnClickListener {
                findNavController().navigate(toDashboardAnalytics())
            }

            dashboardDetailsLogin.setOnClickListener {
                findNavController().navigate(toLogin())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}