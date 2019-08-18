package com.cichosz.brightinventions.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cichosz.brightinventions.database.book.Book
import com.cichosz.brightinventions.database.book.BookDao

@Database(entities = [Book::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun BookDao(): BookDao


    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "bi_db")
                        // TODO: remove this later
                        // this is for tests not to write migration between small db changes
                        .fallbackToDestructiveMigration()
                        .build()
    }
}
