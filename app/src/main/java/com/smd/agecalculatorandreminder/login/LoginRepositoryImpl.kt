package com.smd.agecalculatorandreminder.login

import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor() : LoginRepository {
    override fun onLocalLoginSuccess(username: String, password: String): Int {
        println("Congratulation! Login Successfully done!")
        return 1
    }

    override fun onGoogleLoginSuccess(): Int {
        TODO("Not yet implemented")
    }

    override fun onFacebookLoginSuccess(): Int {
        TODO("Not yet implemented")
    }

    override fun onLoginFail(): Int {
        println("Sorry! Login failed, Try again.")
        return 0
    }

}