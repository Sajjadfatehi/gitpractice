package com.example.paygahdadeh
import androidx.room.*

@Dao
interface TagDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun addTAg(tag: List<TagModel>)
//
//    @Query("SELECT * FROM tags")
//    suspend fun getAllTag(): List<TagModel>
//
//
//    @Transaction
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertTags(tags: List<TagModel>)
//
//
//    @Query("delete from tags where tag=:tag")
//    suspend fun deleteTagByTag(tag: String)
//
//    @Query("delete from tag_article where tag=:tag")
//    suspend fun deleteTagAndArticleByTag(tag: String)
//
//    @Query("delete from tag_article")
//    suspend fun clearTagAndArticle()
}