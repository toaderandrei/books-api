package com.ant.books.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksService {

    @GET("//books/v1/volumes")
    fun volumes(@Query("q") isbn: String): Single<BooksResponse>
}