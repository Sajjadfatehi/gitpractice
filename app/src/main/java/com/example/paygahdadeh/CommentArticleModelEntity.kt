package com.example.paygahdadeh
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "comments", foreignKeys = [ForeignKey(
        onDelete = CASCADE,
        onUpdate = CASCADE,
        parentColumns = ["slug"],
        childColumns = ["article_slug"],
        entity = ArticleDataEntity::class
    )]
)
data class CommentArticleModelEntity(
    @PrimaryKey val id: String,
    val article_slug: String,
    val name: String,
    val description: String
)