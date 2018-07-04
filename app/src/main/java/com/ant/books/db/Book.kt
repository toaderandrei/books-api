package com.ant.books.db

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index

@Entity(
        indices = [
            Index("id"),
            Index("selfLink"),
            Index("volumeInfo")
        ],
        primaryKeys = ["id"]
)

data class Book(
        val id: Int,
        val selfLink: String,
        val volumeInfo: VolumeInfo
) {

    companion object {
        const val UNKNOWN_ID = -1
    }
}
