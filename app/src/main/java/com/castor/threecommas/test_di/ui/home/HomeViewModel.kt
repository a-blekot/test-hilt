package com.castor.threecommas.test_di.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.castor.threecommas.test_di.core.utils.Calculator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val calculator: Calculator
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment\ncalculator($calculator)! = ${calculator.sum(10, 2)}"
    }
    val text: LiveData<String> = _text
}