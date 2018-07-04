package com.ant.books.db

import android.arch.persistence.room.Entity

@Entity(primaryKeys = ["title"])
data class VolumeInfo(
        val title: String,
        val subtitle: String,
        val authors: List<String>,
        val description: String
)