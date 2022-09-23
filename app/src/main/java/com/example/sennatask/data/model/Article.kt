package com.example.sennatask.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(

    val title:String,
    val publishedBy:String,
    val publishedDate:String,
    val summary:String,
    val image:String

): Parcelable
