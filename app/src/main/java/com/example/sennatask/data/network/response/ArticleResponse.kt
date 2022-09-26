package com.example.sennatask.data.network.response

import com.google.gson.annotations.SerializedName

data class ArticleResponse (
        val status:String,
        val copyright:String,
        val num_results:Int,
        val results:List<Result>
)


data class Result(
        @SerializedName("title")
        val title:String,

        @SerializedName("byline")
        val publishedBy:String,

        @SerializedName("published_date")
        val publishedDate:String,

        @SerializedName("abstract")
        val summary:String,


        val media:List<Media>?
)

data class Media(

        @SerializedName("media-metadata")
        val mediaMetadata:List<MediaMetaData>?
)

data class MediaMetaData(
        val url:String
)














