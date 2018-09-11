package com.example.mvp.login

import com.example.mvp.postDelayed

class LoginInteractor {

    // Interface responsible for grouping the actions when the login is finalized
    interface OnLoginFinishedListener {
        fun onUsernameError()
        fun onPasswordError()
        fun onSuccess()
    }

    /*
     * username: Referent the username field in activity
     * password: Referent the password field in activity
     * listener: Referent who is bound by the contract - whatever
     */
    fun login(username: String, password: String, listener: OnLoginFinishedListener) {
        postDelayed(1500) {
            when {
                username.trim().isEmpty() -> listener.onUsernameError()
                password.trim().isEmpty() -> listener.onPasswordError()
                else -> listener.onSuccess()
            }
        }
    }
}