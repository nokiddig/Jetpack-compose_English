package com.example.english_app.domain.usecase
import com.example.english_app.domain.repository.AccountRepository

class LoginUseCase(private val accountRepositoryImpl: AccountRepository) {
    suspend fun execute(username: String, password: String): Boolean {
        return accountRepositoryImpl.login(username, password)
    }
}