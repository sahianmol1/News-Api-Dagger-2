package com.example.newsappdagger.di.app

import com.example.newsappdagger.di.activity.ActivityComponent
import com.example.newsappdagger.di.activity.ActivityModule
import com.example.newsappdagger.ui.activities.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface AppComponent {

    fun newActivityComponentBuilder(): ActivityComponent.Builder
}