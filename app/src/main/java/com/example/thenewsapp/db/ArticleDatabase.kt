package com.example.thenewsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.thenewsapp.models.Article
import kotlin.concurrent.Volatile

@Database(
    entities = [Article::class],
    version = 2 // Increase the version number to 2
)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun getArticleDAO(): ArticleDAO

    companion object {
        @Volatile
        private var instance: ArticleDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
            )
                .fallbackToDestructiveMigration() // Drop and recreate the database if there's a version mismatch
                .build()
    }
}
