package com.example.newsappdagger.di.activity

import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Module
object ActivityModule {

    @Provides
    @ActivityScope
    fun getGlide(activity: AppCompatActivity): RequestManager = Glide.with(activity)

}