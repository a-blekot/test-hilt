package com.castor.threecommas.test_di.core.di

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.navGraphViewModels
import androidx.savedstate.SavedStateRegistryOwner

class SavedStateFactory<T: ViewModel>(
    savedStateRegistryOwner: SavedStateRegistryOwner,
    private val create: (stateHandle: SavedStateHandle) -> T
) : AbstractSavedStateViewModelFactory(savedStateRegistryOwner, null) {

    override fun <T : ViewModel> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
        @Suppress("UNCHECKED_CAST")
        return create.invoke(handle) as T
    }
}

inline fun <reified T : ViewModel> Fragment.savedStateVM(
    noinline create: (stateHandle: SavedStateHandle) -> T
) = viewModels<T> {
    SavedStateFactory(this, create)
}

inline fun <reified T : ViewModel> Fragment.navGraphVM(
    @IdRes navGraphId: Int,
    noinline create: (stateHandle: SavedStateHandle) -> T
) = navGraphViewModels<T>(navGraphId) {
    SavedStateFactory(this, create)
}