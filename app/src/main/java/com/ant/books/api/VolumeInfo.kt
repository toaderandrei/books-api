package com.ant.books.api

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class VolumeInfo(@Json(name = "title") val title: String,
                      @Json(name = "authors") val authors: List<String>) : Parcelable