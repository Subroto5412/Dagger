package com.trining.dagger.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.trining.dagger.R
import com.trining.dagger.data.local.IDataManager
import com.trining.dagger.databinding.ActivityMainBinding
import com.trining.dagger.ui.base.BaseActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), IMainNavigator,
    HasAndroidInjector {

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    private lateinit var mActivityMainBinding: ActivityMainBinding

    @Inject
    lateinit var mMainViewModel: MainViewModel

    override val bindingVariable: Int
        get() = com.trining.dagger.BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel
        get() {
            return mMainViewModel
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityMainBinding = viewDataBinding
        mMainViewModel.navigator = this
    }

    override fun androidInjector(): AndroidInjector<Any>? {
        return fragmentDispatchingAndroidInjector
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}