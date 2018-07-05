package com.ant.books.fragments

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ant.books.R
import com.ant.books.binding.FragmentDataBindingComponent
import com.ant.books.databinding.BookDetailBinding
import com.ant.books.di.Injectable
import com.ant.books.utils.autoCleared
import com.ant.books.viewmodel.BookDetailViewModel
import javax.inject.Inject

class BookDetailFragment : Fragment(), Injectable {

    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    @Inject
    lateinit var viewmodelFactory: ViewModelProvider.Factory

    lateinit var bookDetailViewModel: BookDetailViewModel

    var binding by autoCleared<BookDetailBinding>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.book_detail,
                container,
                false,
                dataBindingComponent)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        bookDetailViewModel = ViewModelProviders.of(this, viewmodelFactory)
                .get(BookDetailViewModel::class.java)
    }
}