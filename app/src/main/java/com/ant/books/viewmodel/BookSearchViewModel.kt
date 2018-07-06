package com.ant.books.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.ant.books.db.Book
import com.ant.books.repository.BookRepository
import com.ant.books.utils.EmptyLiveData
import com.ant.books.viewmodel.status.Resource
import java.util.*
import javax.inject.Inject

class BookSearchViewModel @Inject constructor(bookRepository: BookRepository) : ViewModel() {

    val query = MutableLiveData<String>()

    val searchInput: LiveData<Resource<List<Book>>> = Transformations
            .switchMap(query) { search ->
                if (search.isNullOrBlank()) {
                    EmptyLiveData.create()
                } else {
                    bookRepository.search(search)
                }
            }

    fun refresh() {
        query.value?.let {
            query.value = it
        }
    }

    fun searchBooks(newQuery: String) {
        val input = newQuery.toLowerCase(Locale.getDefault()).trim()
        if (query.value == input) {
            return
        }
        query.value = input

    }

    fun loadNextPage(){
        query.value?.let {
            if(it.isNotBlank()){
                queryNextPage(it)
            }
        }
    }

    private fun queryNextPage(queryNextPage: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}