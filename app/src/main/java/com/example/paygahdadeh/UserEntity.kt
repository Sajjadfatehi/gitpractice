package com.example.paygahdadeh
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
@Entity(tableName = "author")
data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = "username") val username: String,
    @ColumnInfo(name = "image") val image: String?,
    @ColumnInfo(name = "following") val following: Boolean,
    @ColumnInfo(name = "bio") val bio: String? = ""

) : Parcelable,Serializable
