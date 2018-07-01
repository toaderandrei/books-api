package com.ant.books.di

import com.ant.books.service.BooksService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Singleton
    @Provides
    fun providesBooksService(): BooksService {
        return Retrofit
                .Builder()
                .baseUrl("baseurl")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BooksService::class.java)
    }

}