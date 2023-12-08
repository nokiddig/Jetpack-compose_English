package com.example.english_app.data.repository

import com.example.english_app.data.datasource.AccountDataSource
import com.example.english_app.domain.repository.AccountRepository
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(private val userDataSource: AccountDataSource): AccountRepository{
    override suspend fun login(username: String, password: String): Boolean {
        return userDataSource.login(username, password)
    }
}