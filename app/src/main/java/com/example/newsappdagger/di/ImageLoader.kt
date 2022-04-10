package com.example.newsappdagger.di

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import javax.inject.Inject


class ImageLoader @Inject constructor(private val activity: AppCompatActivity) {

    fun loadImage(imageUrl: String, imageView: ImageView) = Glide.with(activity).load(imageUrl).into(imageView)

}