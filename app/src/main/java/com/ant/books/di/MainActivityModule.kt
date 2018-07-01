package com.ant.books.di

import com.ant.books.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [FragmentsBuildersModule::class])
    abstract fun contributesMainActivity(): MainActivity
}
