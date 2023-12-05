package com.example.english_app.presenter.login.event
sealed class LoginEvent {
    // Các sự kiện (actions) được kích hoạt bởi giao diện đăng nhập
    data class OnLoginClicked(val username: String, val password: String) : LoginEvent()
}