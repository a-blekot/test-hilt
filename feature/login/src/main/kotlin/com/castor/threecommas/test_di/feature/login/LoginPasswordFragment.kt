package com.castor.threecommas.test_di.feature.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.castor.threecommas.test_di.core.di.navGraphVM
import com.castor.threecommas.test_di.feature.login.databinding.FragmentLoginPasswordBinding
import javax.inject.Inject

class LoginPasswordFragment : Fragment() {

    @Inject
    lateinit var loginModuleInterface: LoginModuleInterface

    @Inject
    lateinit var loginRepository: LoginRepository

    private var _binding: FragmentLoginPasswordBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by navGraphVM(R.id.login_navigation_graph) {
        LoginComponentHolder.component!!.loginViewModelFactory().create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        LoginComponentHolder.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentLoginPasswordBinding.inflate(inflater, container, false)
        .also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.loginPasswordText.text = superText
        Log.d("VVV", "LoginPasswordFragment viewModel.superText = \n${viewModel.superText}")
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