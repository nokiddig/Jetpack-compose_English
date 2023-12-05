package com.example.english_app.domain.usecase

import com.example.english_app.data.repository.AccountRepository
import com.google.firebase.firestore.auth.User

class LoginUseCase(private val accountRepository: AccountRepository) {
    suspend fun execute(username: String, password: String): User {
        return accountRepository.login(username, password)
    }
}