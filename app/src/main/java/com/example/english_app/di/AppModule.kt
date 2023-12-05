package com.example.english_app.di

import com.example.english_app.data.datasource.AccountDataSource
import com.example.english_app.data.repository.AccountRepository
import com.example.english_app.domain.usecase.LoginUseCase
import com.example.english_app.presentation.login.viewmodel.LoginViewModel
import com.google.android.datatransport.runtime.dagger.Component
import com.google.android.datatransport.runtime.dagger.Provides
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Singleton


class AppModule {
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideUserRepository(dataSource: AccountDataSource): AccountRepository {
        return AccountRepository(dataSource)
    }

    // Các provides khác...
}

@Component(modules = [AppModule::class])
interface AppComponent {
    // Đăng ký các phương thức inject cho các thành phần khác...
}