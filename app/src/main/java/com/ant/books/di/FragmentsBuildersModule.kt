package com.ant.books.di

import com.ant.books.fragments.BookDetailFragment
import com.ant.books.fragments.BookSearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributesSearchBooksFragment(): BookSearchFragment

    @ContributesAndroidInjector
    abstract fun contributesBooksDetailFragment(): BookDetailFragment
}