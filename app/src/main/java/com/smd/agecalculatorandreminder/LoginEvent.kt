package com.smd.agecalculatorandreminder

sealed interface LoginEvent {
    data class SetUsername(val username: String) : LoginEvent
    data class SetPassword(val password: String) : LoginEvent
    object ForgotPassword : LoginEvent
    data class SignIn(val username: String, val password: String) : LoginEvent
    object SignInWithGoogle: LoginEvent
    object SignInWithFacebook: LoginEvent
}