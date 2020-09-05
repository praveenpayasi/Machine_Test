package com.example.praveenpayasimachinetest.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.praveenpayasimachinetest.MainActivity
import com.example.praveenpayasimachinetest.R
import com.example.praveenpayasimachinetest.di.component.ActivityComponent
import com.example.praveenpayasimachinetest.ui.base_emp.BaseActivity
import com.example.praveenpayasimachinetest.ui.users.UserListActivity
import com.example.praveenpayasimachinetest.utils.Event
import com.example.praveenpayasimachinetest.utils.log.Logger

class SplashActivity : BaseActivity<SplashViewModel>() {

    companion object {
        const val TAG = "SplashActivity"
    }

    override fun provideLayoutId(): Int = R.layout.activity_splash

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {
    }

    override fun setupObservers() {
        // Event is used by the view model to tell the activity to launch another activity
        // view model also provided the Bundle in the event that is needed for the Activity
        viewModel.launchMain.observe(this, Observer<Event<Map<String, String>>> {
            it.getIfNotHandled()?.run {
                startActivity(Intent(applicationContext, MainActivity::class.java))
            }
        })

        viewModel.launchLogin.observe(this, Observer {
            it.getIfNotHandled()?.run {
                startActivity(Intent(applicationContext,UserListActivity::class.java))
            }
        })

        viewModel.users.observe(this, Observer {
            it?.run { //postsAdapter.appendData(this)

                Logger.d("user_observer",it.toString())
                }
        })

        viewModel.posts.observe(this, Observer {
            it.data?.run { //postsAdapter.appendData(this)
                //
            }
        })
    }
}