package com.trining.dagger

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.trining.dagger.di.component.DaggerIAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : MultiDexApplication(), HasAndroidInjector {
    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Any>
    val context: Context
        get() = applicationContext

    override fun androidInjector(): AndroidInjector<Any>? {
        return activityDispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        DaggerIAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}