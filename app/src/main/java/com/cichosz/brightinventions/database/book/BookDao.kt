package com.cichosz.brightinventions.database.book

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BookDao {
    @Query("SELECT * FROM books")
    fun getBooks(): List<Book>

    @Query("SELECT * FROM books WHERE id IS :bookId")
    fun getBook(bookId: Int): Book

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(books: List<Book>)

    @Query("DELETE FROM books")
    fun deleteAll()
}