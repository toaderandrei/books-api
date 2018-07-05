package com.ant.books.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.ant.books.viewmodel.BookDetailViewModel
import com.ant.books.viewmodel.BookSearchViewModel
import com.ant.books.viewmodel.BooksViewModelFactory
import com.ant.books.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: BooksViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(BookSearchViewModel::class)
    abstract fun bindSearchViewModel(searchViewModel: BookSearchViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(BookDetailViewModel::class)
    abstract fun bindBookDetailViewModel(bookDetailViewModel: BookDetailViewModel): ViewModel
}