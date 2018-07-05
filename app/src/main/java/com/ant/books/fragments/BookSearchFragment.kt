package com.ant.books.fragments

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.IBinder
import android.support.v4.app.Fragment
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import com.ant.books.R
import com.ant.books.binding.FragmentDataBindingComponent
import com.ant.books.databinding.BookSearchBinding
import com.ant.books.di.Injectable
import com.ant.books.utils.autoCleared
import com.ant.books.viewmodel.BookSearchViewModel
import com.ant.books.viewmodel.RetryCallback
import javax.inject.Inject

class BookSearchFragment : Fragment(), Injectable {

    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)
    var binding by autoCleared<BookSearchBinding>()

    @Inject
    lateinit var viewmodelFactory: ViewModelProvider.Factory

    lateinit var bookSearchViewModel: BookSearchViewModel
    //var binding?
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.book_search,
                container,
                false,
                dataBindingComponent)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bookSearchViewModel = ViewModelProviders
                .of(this, viewmodelFactory)
                .get(BookSearchViewModel::class.java)

        //todo: init adapters. not yet done
        binding.callback = object : RetryCallback {
            override fun retry() {
                bookSearchViewModel.refresh()
            }
        }
    }

    private fun initSearchInputListener() {
        binding.input.setOnEditorActionListener { view: View, actionId: Int, _: KeyEvent? ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                doSearch(view)
                true
            } else {
                false
            }
        }

        binding.input.setOnKeyListener { view: View, keyCode: Int, event: KeyEvent ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                doSearch(view)
                true
            } else {
                false
            }
        }
    }

    private fun doSearch(view: View) {
        val query = binding.input.text.toString()
        dismissKeyboard(view.windowToken)
        binding.query = query
        bookSearchViewModel.searchBooks(query)
        //todo : do the searchBooks
    }

    private fun dismissKeyboard(windowToken: IBinder) {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}