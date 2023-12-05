package com.example.english_app.data.repository

import com.example.english_app.data.datasource.AccountDataSource
import com.google.firebase.firestore.auth.User

class AccountRepository (private val userDataSource: AccountDataSource){
    //Interface hoặc lớp trừu tượng mô tả các phương thức liên quan đến việc đăng nhập và quản lý người dùng.
    suspend fun login(username: String, password: String): Boolean {
        return userDataSource.login(username, password)
    }
}