package com.example.newsappdagger.di.activity

import androidx.appcompat.app.AppCompatActivity
import com.example.newsappdagger.ui.activities.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: AppCompatActivity): Builder
        fun module(module: ActivityModule): Builder
        fun build():ActivityComponent
    }
}