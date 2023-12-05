package com.example.english_app.presenter.login.viewmodel

import androidx.lifecycle.ViewModel
import com.example.english_app.domain.usecase.LoginUseCase

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {
    // Xử lý logic đăng nhập và quản lý trạng thái giao diện người dùng
}