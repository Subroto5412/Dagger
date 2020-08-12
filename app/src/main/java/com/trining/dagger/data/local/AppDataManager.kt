package com.trining.dagger.data.local

import android.content.Context
import com.trining.dagger.data.local.pref.IPreferencesHelper
import javax.inject.Inject

class AppDataManager @Inject
constructor(
    private val mContext: Context,
    private val mPreferencesHelper: IPreferencesHelper
) : IDataManager {
    override var user: String
        get() = mPreferencesHelper.user
        set(user) {
            mPreferencesHelper.user = user
        }
    override var email: String
        get() = mPreferencesHelper.email
        set(email) {
            mPreferencesHelper.email = email
        }
}