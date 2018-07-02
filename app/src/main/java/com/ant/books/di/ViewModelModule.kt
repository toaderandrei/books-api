package com.ant.books.di

import android.arch.lifecycle.ViewModelProvider
import com.ant.books.viewmodel.BooksViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: BooksViewModelFactory): ViewModelProvider.Factory
}