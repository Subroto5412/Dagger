package com.trining.dagger.di.module

import android.app.Application
import android.content.Context
import com.trining.dagger.data.local.AppDataManager
import com.trining.dagger.data.local.IDataManager
import com.trining.dagger.data.local.pref.IPreferencesHelper
import com.trining.dagger.data.local.pref.PreferencesHelper
import com.trining.dagger.di.PreferenceInfo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): IDataManager {
        return appDataManager
    }

    @Provides
    @PreferenceInfo
    internal fun providePreferenceName(): String {
        return "dagger_pref"
    }

    @Provides
    @Singleton
    internal fun providePreferencesHelper(appPreferencesHelper: PreferencesHelper): IPreferencesHelper {
        return appPreferencesHelper
    }
}