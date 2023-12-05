package com.example.english_app.domain.repository

interface AccountRepository {
    suspend fun login(username: String, password: String): Boolean

}