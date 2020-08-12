package com.trining.dagger.di.component

import android.app.Application
import com.trining.dagger.App
import com.trining.dagger.di.builder.ActivityBuilder
import com.trining.dagger.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface IAppComponent : AndroidInjector<App> {

    override fun inject(app: App)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): IAppComponent
    }

}