package com.castor.threecommas.test_di.ui.dashboard.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.castor.threecommas.test_di.databinding.FragmentDashboardDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardDetailsFragment : Fragment() {

    private val viewModel: DashboardDetailsViewModel by viewModels()
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
        binding.dashboardDetailsRepoInfo.text = viewModel.text

        binding.dashboardDetailsButton.setOnClickListener {
            findNavController().navigate(DashboardDetailsFragmentDirections.toDashboardAnalytics())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}