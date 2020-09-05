package com.example.praveenpayasimachinetest.ui.splash

import androidx.lifecycle.MutableLiveData
import com.example.praveenpayasimachinetest.data.local.db.DatabaseService
import com.example.praveenpayasimachinetest.data.model.Post
import com.example.praveenpayasimachinetest.data.model.User
import com.example.praveenpayasimachinetest.data.remote.NetworkService
import com.example.praveenpayasimachinetest.data.repository.PostRepository
import com.example.praveenpayasimachinetest.data.repository.UserRepository
import com.example.praveenpayasimachinetest.ui.base_emp.BaseViewModel
import com.example.praveenpayasimachinetest.utils.Event
import com.example.praveenpayasimachinetest.utils.Resource
import com.example.praveenpayasimachinetest.utils.network.NetworkHelper
import com.example.praveenpayasimachinetest.utils.rx.SchedulerProvider
import io.reactivex.Flowable.fromIterable
import io.reactivex.Observable.fromIterable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import kotlin.collections.ArrayList


class SplashViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val userRepository: UserRepository,
    private val postRepository: PostRepository,
    private val databaseService: DatabaseService,
    networkService: NetworkService,
    private val allUsersList: ArrayList<User>,
    private val allPostList: ArrayList<Post>
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper,networkService) {

    // Event is used by the view model to tell the activity to launch another Activity
    // view model also provided the Bundle in the event that is needed for the Activity
    val launchMain: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()
    val launchLogin : MutableLiveData<Event<Map<String,String>>> = MutableLiveData()
    val users: MutableLiveData<Resource<List<User>>> = MutableLiveData()
    val posts: MutableLiveData<Resource<List<Post>>> = MutableLiveData()


    override fun onCreate() {
        // Empty Bundle passed to Activity in Event that is needed by the other Activity
        // Here in actual application we will decide which screen to open based on
        // either the user is logged in or not
       /* if (userRepository.getCurrentUser() != null)
            launchMain.postValue(Event(emptyMap()))
        else launchLogin.postValue(Event(emptyMap()))*/
        getUserListFromApi()

        getPostListFromApi()

    }

    private fun getUserListFromApi(){
        userRepository.doUserCall()
                .flatMap { it ->
                    Observable.fromIterable(it)
                }
            .subscribeOn(Schedulers.io())
            .subscribe({
                //allUsersList.addAll(it)
                databaseService.userDao().insertMany(it)
                users.postValue(Resource.success(it))

            },{
                handleNetworkError(it)
            })

    }

    private fun getPostListFromApi(){
        postRepository.fetchPostList()
            ?.subscribeOn(Schedulers.io())
            ?.subscribe({
                //allPostList.addAll(it)
                posts.postValue(Resource.success(it))
                launchLogin.postValue(Event(emptyMap()))
            },{
                handleNetworkError(it)
            })

    }

    private fun insertUserListIntoDB(){

    }

}

