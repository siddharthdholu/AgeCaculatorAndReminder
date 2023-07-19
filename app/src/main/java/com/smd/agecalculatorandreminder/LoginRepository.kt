package com.smd.agecalculatorandreminder

interface LoginRepository {
    fun onLocalLoginSuccess(username: String, password: String): Int
    fun onGoogleLoginSuccess(): Int
    fun onFacebookLoginSuccess(): Int
    fun onLoginFail(): Int
}