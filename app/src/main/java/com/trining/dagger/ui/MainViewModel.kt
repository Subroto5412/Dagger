package com.trining.dagger.ui

import androidx.databinding.ObservableField
import com.trining.dagger.data.local.IDataManager
import com.trining.dagger.ui.base.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    dataManager: IDataManager
) :
    BaseViewModel<IMainNavigator>(dataManager) {

    val userTxt: ObservableField<String>
    val emailTxt: ObservableField<String>

    init {
        dataManager.user = "Subroto"
        dataManager.email = "Subroto@gmail.com"
        userTxt = ObservableField(dataManager.user)
        emailTxt = ObservableField(dataManager.email)
    }

}
