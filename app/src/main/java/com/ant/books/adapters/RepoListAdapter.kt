package com.ant.books.adapters

import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ant.books.R
import com.ant.books.databinding.BookItemBinding
import com.ant.books.db.Book
import com.ant.books.threading.AppExecutors

class RepoListAdapter(
        private val dataBindingComponent: DataBindingComponent,
        private val showDescription: Boolean,
        appExecutors: AppExecutors
) : BaseListAdapter<Book, BookItemBinding>(
        appExecutors = appExecutors,
        itemCallback = object : DiffUtil.ItemCallback<Book>() {
            override fun areContentsTheSame(oldItem: Book?, newItem: Book?): Boolean {
                return oldItem?.id == newItem?.id
            }

            override fun areItemsTheSame(oldItem: Book?, newItem: Book?): Boolean {
                return oldItem?.volumeInfo?.title == newItem?.volumeInfo?.title
                        && oldItem?.selfLink == newItem?.selfLink
                        && oldItem?.volumeInfo?.description == newItem?.volumeInfo?.description
            }

        }) {

    override fun bind(binding: BookItemBinding, item: Book) {
        binding.book = item
    }


    override fun createBinding(parent: ViewGroup): BookItemBinding {
        val itemBinding = DataBindingUtil.inflate<BookItemBinding>(LayoutInflater.from(parent.context),
                R.layout.book_item,
                parent,
                false,
                dataBindingComponent)

        itemBinding.showDescription = showDescription
        //todo add click listener.s
        return itemBinding
    }
}