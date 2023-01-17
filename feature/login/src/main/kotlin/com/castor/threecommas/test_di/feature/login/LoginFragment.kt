package com.castor.threecommas.test_di.feature.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.castor.threecommas.test_di.core.di.Factory
import com.castor.threecommas.test_di.core.di.FeatureScope
import com.castor.threecommas.test_di.feature.login.LoginFragmentDirections.Companion.toName
import com.castor.threecommas.test_di.feature.login.databinding.FragmentLoginBinding
import com.castor.threecommas.test_di.feature.login.di.LoginComponentHolder
import com.castor.threecommas.test_di.feature.login.di.LoginModuleInterface
import com.castor.threecommas.test_di.feature.login.di.LoginRepository
import javax.inject.Inject

@FeatureScope
class LoginFragment : Fragment() {

    @Inject
    lateinit var loginRepository: LoginRepository

    @Inject
    lateinit var loginModuleInterface: LoginModuleInterface

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
//    private val viewModel: LoginViewModel by viewModels()

//    private val viewModel: LoginViewModel by viewModels {
//        LoginComponentHolder.component!!.viewModelFactory().create()
//    }

    private val viewModel: LoginViewModel by navGraphViewModels(R.id.login_navigation_graph) {
        Factory { LoginComponentHolder.subComponent!!.loginViewModel() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        LoginComponentHolder.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        LoginComponentHolder.reset()
        super.onDestroy()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentLoginBinding.inflate(inflater, container, false)
        .also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.run {
            loginText.text = superText
            Log.d("VVV", "LoginFragment viewModel.superText = \n${viewModel.superText}")
            fragmentLoginButton.setOnClickListener {
                findNavController().navigate(toName())
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

val Any.address: String get() = toString().takeLast(8)