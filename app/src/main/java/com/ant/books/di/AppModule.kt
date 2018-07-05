package com.ant.books.di

import com.ant.books.api.BooksService
import com.ant.books.threading.AppExecutors
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
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
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(BooksService::class.java)
    }

    @Singleton
    @Provides
    fun providesAppExecutors(): AppExecutors {
        return AppExecutors()
    }

}