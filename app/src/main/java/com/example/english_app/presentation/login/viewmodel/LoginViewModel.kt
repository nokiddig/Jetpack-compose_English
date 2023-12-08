package com.example.english_app.presentation.login.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.english_app.domain.usecase.LoginUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {
    // Xử lý logic đăng nhập và quản lý trạng thái giao diện người dùng
    fun login(username: String, password: String) {
        viewModelScope.launch {
            val success = loginUseCase.execute(username, password)
            if (success) {
                // Xử lý sau khi đăng nhập thành công
                Log.d("sylog", "Login success")
            } else {
                // Xử lý sau khi đăng nhập thất bại
                Log.d("sylog", "Login fail")
            }
        }
    }
}