package com.example.praveenpayasimachinetest.di.component

import com.example.praveenpayasimachinetest.di.ActivityScope
import com.example.praveenpayasimachinetest.di.module.ActivityModule
import com.example.praveenpayasimachinetest.ui.add_user.AddUserActivity
import com.example.praveenpayasimachinetest.ui.list_post.PostListActivity
import com.example.praveenpayasimachinetest.ui.users.UserListActivity
import com.example.praveenpayasimachinetest.ui.splash.SplashActivity
import dagger.Component


@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {


    fun inject(activity: SplashActivity)

    fun inject(activity : AddUserActivity)

    fun inject(activity : UserListActivity)

    fun inject(activity : PostListActivity)
}