package com.example.newsappdagger.ui

import androidx.appcompat.app.AppCompatActivity
import com.example.newsappdagger.di.activity.ActivityModule
import com.example.newsappdagger.di.app.ApplicationModule
import com.example.newsappdagger.di.app.DaggerAppComponent

open class BaseActivity : AppCompatActivity() {

    private val appComponent by lazy {
        DaggerAppComponent.builder().applicationModule(ApplicationModule()).build()
    }

    private val activityComponent by lazy {
        appComponent.newActivityComponentBuilder().activity(this).module(ActivityModule).build()
    }

    protected val injector get() = activityComponent

}