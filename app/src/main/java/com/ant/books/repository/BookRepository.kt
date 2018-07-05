package com.ant.books.repository

import android.arch.lifecycle.LiveData
import com.ant.books.db.Book
import com.ant.books.viewmodel.status.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookRepository @Inject constructor() {
    fun search(query: String): LiveData<Resource<List<Book>>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}