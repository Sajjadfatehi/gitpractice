package com.example.paygahdadeh
import androidx.room.*

@Dao
interface ArticleDao {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(articles: List<ArticleDataEntity>)

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOneByOne(articles: ArticleDataEntity)

    @Update
    suspend fun update(article: ArticleDataEntity)
//
//    @Query("SELECT * FROM article WHERE slug in(SELECT slug FROM tag_article WHERE tag =:text)")
//    suspend fun getArticleWithTag(text: String): List<ArticleUser>

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticleTag(tagAndArticleEntity: List<TagAndArticleEntity>)

    @Query("delete from article where slug=:slug")
    suspend fun deleteArticle(slug: String)

    @Query("select * from article")
    suspend fun getAllArticles(): MutableList<ArticleDataEntity>

    @Query("delete from article where authorusername=:userName")
    suspend fun deleteArticleByUserName(userName: String)
//
//    @Query("delete from user_favorite_article where username=:userName")
//    suspend fun deleteFavoriteArticleOfUser(userName: String)
//
//    @Query("delete from user_favorite_article ")
//    suspend fun deleteAllFavoriteArticleOfUser()
//
//    @Query("select * from tag_article")
//    suspend fun getAllTagAndArticle(): List<TagAndArticleEntity>


}