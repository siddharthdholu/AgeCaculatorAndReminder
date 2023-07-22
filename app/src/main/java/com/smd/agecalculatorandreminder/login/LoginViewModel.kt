package com.smd.agecalculatorandreminder.login

import android.util.Log
import com.smd.agecalculatorandreminder.base.BaseViewModel
import com.smd.agecalculatorandreminder.util.MLog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository
) : BaseViewModel<LoginState, LoginEvent>() {
    private val mLog = MLog(LoginViewModel::class.simpleName.toString())

    //private val _state = MutableStateFlow(LoginState())
    //val state: StateFlow<LoginState> = _state

    override fun defaultState() = LoginState()
    override fun onEvent(event: LoginEvent) {
        when (event) {
            LoginEvent.ForgotPassword -> {
                mLog.d("ForgotPassword Clicked")
            }

            is LoginEvent.SetPassword -> {
                _state.update {
                    it.copy(
                        password = event.password
                    )
                }
                mLog.d("Password: ${event.password}")
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

            LoginEvent.SignUp -> {
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