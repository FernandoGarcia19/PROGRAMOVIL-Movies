package com.calyrsoft.ucbp1.features.profile.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.calyrsoft.ucbp1.features.profile.domain.model.ProfileModel
import com.calyrsoft.ucbp1.features.profile.domain.usecase.loadProfileUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProfileViewModel(
    val usecase: loadProfileUseCase
): ViewModel() {
    sealed class ProfileStateUI {
        object Init: ProfileStateUI()
        object Loading: ProfileStateUI()
        class Error(val message: String): ProfileStateUI()
        class Success(val profile: ProfileModel): ProfileStateUI()
    }
    private val _state = MutableStateFlow<ProfileStateUI>(ProfileStateUI.Init)

    val state : StateFlow<ProfileStateUI> = _state.asStateFlow()

    init {
        fetchProfile()
    }

    fun fetchProfile() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = ProfileStateUI.Loading
            val result = usecase.invoke()
            result.fold(
                onSuccess = { profile ->
                    _state.value = ProfileStateUI.Success(profile)
                },
                onFailure = { error ->
                    _state.value = ProfileStateUI.Error(error.message ?: "Error al cargar el perfil")
                }
            )
        }
    }
}