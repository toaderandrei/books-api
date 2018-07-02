package com.ant.books.fragments

import android.arch.lifecycle.ViewModelProvider
import android.support.v4.app.Fragment
import com.ant.books.di.Injectable
import javax.inject.Inject

//@OpenForTesting - todo - fix this.
class BooksFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    //lateinit var Books
}