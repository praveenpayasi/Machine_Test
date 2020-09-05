package com.example.praveenpayasimachinetest.ui.users

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.praveenpayasimachinetest.data.local.db.DatabaseService
import com.example.praveenpayasimachinetest.data.model.User
import com.example.praveenpayasimachinetest.data.remote.NetworkService
import com.example.praveenpayasimachinetest.data.repository.PostRepository
import com.example.praveenpayasimachinetest.data.repository.UserRepository
import com.example.praveenpayasimachinetest.ui.base_emp.BaseViewModel
import com.example.praveenpayasimachinetest.utils.network.NetworkHelper
import com.example.praveenpayasimachinetest.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class UserListViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val userRepository: UserRepository,
    private val postRepository: PostRepository,
    private val databaseService: DatabaseService,
    networkService: NetworkService
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper,networkService) {

    companion object {
        const val TAG = "UserListViewModel"
    }

    val user = MutableLiveData<User>()
    val allUser = MutableLiveData<List<User>>()
    //val allAddress = MutableLiveData<List<Address>>()

    private var users: List<User> = emptyList()
    //private var addresses: List<Address> = ArrayList()


    override fun onCreate() {
        getAllUserFromDB()
    }

    private fun getAllUserFromDB() {
        compositeDisposable.add(
            databaseService.userDao()
                .getAll()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        users = it
                        Log.e(TAG, "getAllUserFromDB: "+users.get(0))
                        allUser.postValue(it)
                    },
                    {
                        Log.d(TAG, it.toString())
                    }
                )
        )
    }

    fun onDestroy() {
        compositeDisposable.clear()
    }

}