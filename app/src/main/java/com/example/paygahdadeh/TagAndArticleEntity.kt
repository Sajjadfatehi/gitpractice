package com.example.paygahdadeh
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE

@Entity(
    tableName = "tagOfArticle",
    primaryKeys = ["tag", "slug"],
    foreignKeys = [
        ForeignKey(
            entity = ArticleDataEntity::class,
            parentColumns = ["slug"],
            childColumns = ["slug"],
            onUpdate = CASCADE,
            onDelete = CASCADE
        )]
)
data class TagAndArticleEntity(
    @ColumnInfo(name = "tag") val tag: String,
    @ColumnInfo(name = "slug") val article: String
)