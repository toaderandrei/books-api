package com.ant.books.di;

import android.app.Application
import com.ant.books.application.BooksApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
        modules = [
            AppModule::class,
            AndroidInjectionModule::class,
            MainActivityModule::class
        ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicatiomn(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(booksApp: BooksApp)
}