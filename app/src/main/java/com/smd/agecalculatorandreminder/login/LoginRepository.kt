package com.smd.agecalculatorandreminder.login

interface LoginRepository {
    fun onLocalLoginSuccess(username: String, password: String): Int
    fun onGoogleLoginSuccess(): Int
    fun onFacebookLoginSuccess(): Int
    fun onLoginFail(): Int
}