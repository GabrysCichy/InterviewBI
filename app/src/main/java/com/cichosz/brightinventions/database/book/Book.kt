package com.cichosz.brightinventions.database.book

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class Book(
    @PrimaryKey @ColumnInfo(name = "id") val bookId: Int,
    val title: String,
    val author: String,
    val pages: Int,
    val ISBN: String,
    val rating: Int
)