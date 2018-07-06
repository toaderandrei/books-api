package com.ant.books.repository.rx

import android.arch.lifecycle.LiveData
import com.ant.books.api.BooksService
import com.ant.books.db.Book
import com.ant.books.utils.EmptyLiveData
import com.ant.books.viewmodel.status.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RxBooksRepository @Inject constructor(private val booksService: BooksService) {
    fun loadBooks(query: String): LiveData<Resource<List<Book>>> {
        return EmptyLiveData.create()
    }
}