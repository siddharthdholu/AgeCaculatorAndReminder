package com.smd.agecalculatorandreminder

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository
) : ViewModel() {
    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state

    fun onEvent(event: LoginEvent) {
        when (event) {
            LoginEvent.ForgotPassword -> {
                Log.d("ViewModel", "ForgotPassword Clicked")
            }

            is LoginEvent.SetPassword -> {
                _state.update {
                    it.copy(
                        password = event.password
                    )
                }
                Log.d("ViewModel", "Password: ${event.password}")
            }

            is LoginEvent.SetUsername -> {
                _state.update {
                    it.copy(
                        username = event.username
                    )
                }
                Log.d("ViewModel", "Username: ${event.username}")
            }

            is LoginEvent.SignIn -> {
                Log.d("ViewModel", "Sign In Clicked")
                signIn(event.username, event.password)

            }

            LoginEvent.SignInWithFacebook -> {
                Log.d("ViewModel", "Facebook Clicked")
            }

            LoginEvent.SignInWithGoogle -> {
                Log.d("ViewModel", "Google Clicked")
            }
        }
    }

    private fun signIn(username: String, password: String) {
        if (!username.equals("sid", true)) {
            repository.onLoginFail()
            return
        }
        if (!password.equals("123", true)) {
            repository.onLoginFail()
            return
        }
        repository.onLocalLoginSuccess(username, password)
    }
}