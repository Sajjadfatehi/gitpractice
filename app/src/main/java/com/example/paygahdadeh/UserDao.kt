package com.example.paygahdadeh
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Query("select * from author")
    fun getAllUsers(): LiveData<List<UserEntity>>

    @Query("select * from author")
    fun getAllUsers2(): List<UserEntity>

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: List<UserEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertComment(commentArticleModelEntity: CommentArticleModelEntity)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertTag(tagModel: TagModel)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertUserAndFavoriteArticle(userAndFavoriteArticles: List<UserAndHisFavoriteArticle>)
//
//    @Delete
//    suspend fun deleteUserAndFavoriteArticle(vararg userAndFavoriteArticles: UserAndHisFavoriteArticle)

    @Update
    fun updateUsers(vararg userEntity: UserEntity)

    @Update
    fun updateComments(vararg commentArticleModelEntity: CommentArticleModelEntity)

//    @Update
//    fun updateTags(vararg tagModel: TagModel)

    @Delete
    fun deleteUsers(vararg userEntity: UserEntity)

    @Delete
    fun deleteComments(vararg commentArticleModelEntity: CommentArticleModelEntity)

//    @Delete
//    fun deleteTags(vararg tagModel: TagModel)
//
//    @Query("select * from tags")
//    fun getAllTags(): LiveData<List<TagModel>>

    @Query("select * from comments")
    fun getAllComments(): LiveData<List<CommentArticleModelEntity>>

    @Query("select * from author where username=:userName")
    suspend fun getUser(userName: String): UserEntity
//
//    @Query("select * from article where slug in(select slug from user_favorite_article WHERE username =:userName)")
//    suspend fun getFavoriteArticlesByUser(userName: String): MutableList<ArticleUser>
//
//
//    @Query("select * from article where authorusername=:userName")
//    suspend fun getArticlesByAuthor(userName: String): MutableList<ArticleUser>


}
