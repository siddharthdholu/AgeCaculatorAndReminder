package com.smd.agecalculatorandreminder.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // TODO: Retrofit module

    /* @Provides
     @Singleton
     fun provideLoginRepository(): LoginRepository {
         return LoginRepositoryImpl()
     }*/
}