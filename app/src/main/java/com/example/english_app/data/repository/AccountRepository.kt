package com.example.english_app.data.repository

import com.google.firebase.firestore.auth.User

interface AccountRepository {
    //Interface hoặc lớp trừu tượng mô tả các phương thức liên quan đến việc đăng nhập và quản lý người dùng.
    suspend fun login(username: String, password: String): User
}