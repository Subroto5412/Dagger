package com.trining.dagger.di.module

import androidx.lifecycle.ViewModelProvider
import com.trining.dagger.di.factory.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

}