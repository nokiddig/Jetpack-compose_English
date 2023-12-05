package com.example.english_app.presenter.login.state

import com.google.firebase.firestore.auth.User

sealed class LoginState {
    object Idle : LoginState()
    object Loading : LoginState()
    data class Error(val message: String) : LoginState()
    data class Success(val user: User) : LoginState()
}