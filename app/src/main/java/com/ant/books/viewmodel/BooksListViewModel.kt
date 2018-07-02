package com.ant.books.viewmodel;

import android.arch.lifecycle.ViewModel
import com.ant.books.manager.BooksManager
import javax.inject.Inject

class BooksListViewModel @Inject constructor(books: BooksManager) : ViewModel() {


}