package com.ant.books.threading

import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class AppExecutors(private val backgroundThread: Executor) {

    @Inject constructor() : this(
            backgroundThread = Executors.newSingleThreadExecutor()
    )

    fun backgroundThread(): Executor {
        return backgroundThread
    }
}