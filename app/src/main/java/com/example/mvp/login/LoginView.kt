package com.example.mvp.login

// Interface responsible for mapping all the actions that occur in an activity
interface LoginView {
    fun showProgress()
    fun hideProgress()
    fun setUsernameError()
    fun setPasswordError()
    fun navigateToHome()
}