package com.trining.dagger.ui.base

import androidx.lifecycle.ViewModel
import com.trining.dagger.data.local.IDataManager
import java.lang.ref.WeakReference

abstract class BaseViewModel<N>(
    val dataManager: IDataManager
) : ViewModel() {
    private var mNavigator: WeakReference<N>? = null

    var navigator: N?
        get() = if (mNavigator != null) {
            mNavigator!!.get()
        } else {
            null
        }
        set(navigator) {
            this.mNavigator = WeakReference<N>(navigator)!!
        }
}