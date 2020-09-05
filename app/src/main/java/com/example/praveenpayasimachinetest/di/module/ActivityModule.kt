package com.example.praveenpayasimachinetest.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.praveenpayasimachinetest.data.local.db.DatabaseService
import com.example.praveenpayasimachinetest.data.remote.NetworkService
import com.example.praveenpayasimachinetest.data.repository.PostRepository
import com.example.praveenpayasimachinetest.data.repository.UserRepository
import com.example.praveenpayasimachinetest.ui.add_user.AddUserViewModel
import com.example.praveenpayasimachinetest.ui.base_emp.BaseActivity
import com.example.praveenpayasimachinetest.ui.splash.SplashViewModel
import com.example.praveenpayasimachinetest.ui.users.UserListViewModel
import com.example.praveenpayasimachinetest.ui.users.list_user.UserAdapter
import com.example.praveenpayasimachinetest.utils.ViewModelProviderFactory
import com.example.praveenpayasimachinetest.utils.network.NetworkHelper
import com.example.praveenpayasimachinetest.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Kotlin Generics Reference: https://kotlinlang.org/docs/reference/generics.html
 * Basically it means that we can pass any class that extends BaseActivity which take
 * BaseViewModel subclass as parameter
 */
@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(activity)

    @Provides
    fun provideAddUserViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        userRepository: UserRepository,
        postRepository: PostRepository,
        databaseService: DatabaseService,
        networkService: NetworkService

    ): AddUserViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(AddUserViewModel::class) {
            AddUserViewModel(schedulerProvider,compositeDisposable,networkHelper,userRepository,postRepository,databaseService,networkService)
        }).get(AddUserViewModel::class.java)

    @Provides
    fun provideSplashViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        userRepository: UserRepository,
        postRepository: PostRepository,
        databaseService: DatabaseService,
        networkService: NetworkService
    ): SplashViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(SplashViewModel::class) {
            SplashViewModel(schedulerProvider, compositeDisposable, networkHelper, userRepository,postRepository,databaseService,networkService,ArrayList(),ArrayList())
        }).get(SplashViewModel::class.java)

    @Provides
    fun provideUserAdapter() = UserAdapter(activity.lifecycle, ArrayList())

    @Provides
    fun provideUserListViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        userRepository: UserRepository,
        postRepository: PostRepository,
        databaseService: DatabaseService,
        networkService: NetworkService
    ): UserListViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(UserListViewModel::class) {
            UserListViewModel(schedulerProvider, compositeDisposable, networkHelper, userRepository,postRepository,databaseService,networkService)
        }).get(UserListViewModel::class.java)


    /* @Provides
     fun provideLoginViewModel(
         schedulerProvider: SchedulerProvider,
         compositeDisposable: CompositeDisposable,
         networkHelper: NetworkHelper,
         userRepository: UserRepository
     ): LoginViewModel = ViewModelProviders.of(
         activity, ViewModelProviderFactory(LoginViewModel::class) {
             LoginViewModel(schedulerProvider, compositeDisposable, networkHelper, userRepository)
         }).get(LoginViewModel::class.java)

 */
    /*@Provides
    fun provideMainViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
    ): MainViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(MainViewModel::class) {
            MainViewModel(schedulerProvider, compositeDisposable, networkHelper)
        }).get(MainViewModel::class.java)*/


}