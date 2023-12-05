package com.example.english_app.data.datasource

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.tasks.await

class AccountDataSource {
    private val auth:FirebaseAuth = com.google.firebase.Firebase.auth
    suspend fun login(username: String, password: String): Boolean{//: LoginResponse {
        // Gửi yêu cầu đăng nhập đến API từ xa và nhận lại kết quả
        return try {
            val result = auth.signInWithEmailAndPassword(username, password).await()
            result.user != null
        } catch (e: Exception) {
            false
        }
    }
}