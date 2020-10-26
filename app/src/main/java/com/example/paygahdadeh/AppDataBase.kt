package com.example.paygahdadeh

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration


@Database(
    entities = [UserEntity::class, ArticleDataEntity::class,
        CommentArticleModelEntity::class, TagAndArticleEntity::class],
    version = 1,
    exportSchema = false
)
//@TypeConverters(Converters::class)
abstract class AppDataBase() : RoomDatabase() {

    abstract fun articleDao(): ArticleDao

    abstract fun tagDao(): TagDao

    abstract fun userDao(): UserDao



    companion object {

        @Volatile
        private var instance:AppDataBase?=null
        private val LOCK=Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance=it }
        }
        private const val databaseName = "data_base"

        fun buildDatabase(
            context: Context
        ): AppDataBase {
            return Room.databaseBuilder(context, AppDataBase::class.java, databaseName)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()

                .build()
        }
    }

}