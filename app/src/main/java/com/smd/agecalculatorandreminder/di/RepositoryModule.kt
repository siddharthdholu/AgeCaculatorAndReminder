package com.smd.agecalculatorandreminder.di

import com.smd.agecalculatorandreminder.LoginRepository
import com.smd.agecalculatorandreminder.LoginRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindLoginRepository(
        myRepositoryImpl: LoginRepositoryImpl
    ): LoginRepository
}
