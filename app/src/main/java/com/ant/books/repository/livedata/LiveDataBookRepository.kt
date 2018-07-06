package com.ant.books.repository.livedata

import android.arch.lifecycle.LiveData
import com.ant.books.api.BooksService
import com.ant.books.db.Book
import com.ant.books.utils.EmptyLiveData
import com.ant.books.viewmodel.status.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LiveDataBooksRepository @Inject constructor(private val bookService: BooksService) {
    fun loadBooks(query: String): LiveData<Resource<List<Book>>> {
        return EmptyLiveData.create()
    }
}