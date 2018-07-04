package com.ant.books.fragments

import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ant.books.R
import com.ant.books.binding.FragmentDataBindingComponent
import com.ant.books.databinding.BookSearchBinding
import com.ant.books.di.Injectable

class BookSearchFragment : Fragment(), Injectable {

    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)
    //var binding by autoCleared<BookSearchFragmentBinding>()

    //var binding?
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
       val binding = DataBindingUtil.inflate<BookSearchBinding>(
                inflater,
                R.layout.book_search,
                container,
                false,
                dataBindingComponent)

        return binding.root
    }
}