package com.trining.dagger.di.builder

import com.trining.dagger.ui.MainActivity
import com.trining.dagger.ui.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes =
    [MainActivityModule::class]
)

abstract class ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [MainActivityModule::class]
    )
    internal abstract fun bindMainActivity(): MainActivity
}