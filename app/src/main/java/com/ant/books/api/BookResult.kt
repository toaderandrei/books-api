package com.ant.books.api

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class BookResult(@Json(name = "id") val id: String,
                      @Json(name = "selfLink") val selfLink: String,
                      @Json(name="volumeInfo") val volumeInfo: VolumeInfo) : Parcelable