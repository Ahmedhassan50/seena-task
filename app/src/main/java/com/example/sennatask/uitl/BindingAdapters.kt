package com.example.sennatask.uitl

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.sennatask.R


@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView,url:String?){

    if (url!=null){
        Glide.with(imageView.rootView).load(url)
            .placeholder(R.drawable.plain_white_background)
            .error(R.drawable.plain_white_background)
            .into(imageView)
    }

}
