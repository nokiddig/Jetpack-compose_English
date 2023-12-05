package com.example.english_app.data.repository

import com.example.english_app.data.datasource.AccountDataSource
import com.example.english_app.domain.repository.AccountRepository

class AccountRepositoryImpl (private val userDataSource: AccountDataSource): AccountRepository{
    override suspend fun login(username: String, password: String): Boolean {
        return userDataSource.login(username, password)
    }
}