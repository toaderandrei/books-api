package com.ant.books.adapters

import android.databinding.ViewDataBinding
import android.support.v7.recyclerview.extensions.AsyncDifferConfig
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.view.ViewGroup
import com.ant.books.threading.AppExecutors

abstract class BaseListAdapter<T, V : ViewDataBinding>(
        appExecutors: AppExecutors,
        itemCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, DataBindHolder<V>>(
        AsyncDifferConfig.Builder<T>(itemCallback)
                .setBackgroundThreadExecutor(appExecutors.backgroundThread())
                .build()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindHolder<V> {
        val binding = createBinding(parent)
        return DataBindHolder(binding)
    }

    abstract fun createBinding(parent: ViewGroup): V

    override fun onBindViewHolder(holder: DataBindHolder<V>, position: Int) {
        bind(holder.binding, getItem(position))
    }

    protected abstract fun bind(binding: V, item: T)
}