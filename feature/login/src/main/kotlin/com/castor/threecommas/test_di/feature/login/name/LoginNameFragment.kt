package com.castor.threecommas.test_di.feature.login.name

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.castor.threecommas.test_di.core.di.Factory
import com.castor.threecommas.test_di.core.di.FeatureScope
import com.castor.threecommas.test_di.feature.login.di.LoginComponentHolder
import com.castor.threecommas.test_di.feature.login.di.LoginModuleInterface
import com.castor.threecommas.test_di.feature.login.name.LoginNameFragmentDirections.Companion.toPassword
import com.castor.threecommas.test_di.feature.login.di.LoginRepository
import com.castor.threecommas.test_di.feature.login.address
import com.castor.threecommas.test_di.feature.login.databinding.FragmentLoginNameBinding
import javax.inject.Inject

@FeatureScope
class LoginNameFragment : Fragment() {

    @Inject
    lateinit var loginModuleInterface: LoginModuleInterface

    @Inject
    lateinit var loginRepository: LoginRepository

    private var _binding: FragmentLoginNameBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginNameViewModel by viewModels {
        Factory { LoginComponentHolder.component!!.loginNameViewModel() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        LoginComponentHolder.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentLoginNameBinding.inflate(inflater, container, false)
        .also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.run {
            loginNameText.text = superText
            Log.d("VVV", "LoginNameFragment viewModel.superText = \n${viewModel.superText}")
            fragmentLoginNameButton.setOnClickListener {
                findNavController().navigate(toPassword())
            }
        }
    }

    private val superText: String
        get() {
            val sb = StringBuilder(50)
            sb.append(loginModuleInterface.msg)
            sb.append("\n\nloginModuleInterface ${loginModuleInterface.address}")
            sb.append("\n\nloginRepository ${loginRepository.address}")
            sb.append("\n\nuserRepository ${loginRepository.userRepository.address}")
            sb.append("\n\nanalyticsService ${loginRepository.analyticsService.address}")
            return sb.toString()
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}