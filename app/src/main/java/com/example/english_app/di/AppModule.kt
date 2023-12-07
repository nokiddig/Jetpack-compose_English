package com.example.english_app.di

import com.example.english_app.data.datasource.AccountDataSource
import com.example.english_app.data.repository.AccountRepositoryImpl
import com.example.english_app.domain.repository.AccountRepository
import com.example.english_app.domain.usecase.LoginUseCase
import com.example.english_app.presentation.login.view.LoginActivity
import com.example.english_app.presentation.login.viewmodel.LoginViewModel
import com.google.android.datatransport.runtime.dagger.Component
import com.google.android.datatransport.runtime.dagger.Module
import com.google.android.datatransport.runtime.dagger.Provides
import com.google.firebase.auth.FirebaseAuth

@Module
class AppModule {
//    @Provides
//    fun provideLoginUseCase(): LoginUseCase {
//        return LoginUseCase()
//    }
//    @Provides
//    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()
//    @Provides
//    fun provideLoginViewModel(): LoginViewModel {
//
//        return LoginViewModel()
//    }
//
//    @Provides
//    fun provideUserRepository(dataSource: AccountDataSource): AccountRepository {
//        return AccountRepositoryImpl(dataSource)
//    }
//
//    @Provides
//    fun provideLoginActivity(): LoginActivity {
//        return LoginActivity()
//    }

    @Provides
    fun provideLoginViewModel(loginActivity: LoginActivity): LoginViewModel {
        return loginActivity.loginViewModel
    }
}

@Component(modules = [AppModule::class])
interface AppComponent {
    // Đăng ký các phương thức inject cho các thành phần khác...
}