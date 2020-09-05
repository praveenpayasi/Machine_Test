package com.example.praveenpayasimachinetest.ui.users.list_user


import android.provider.Settings.Global.getString
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.praveenpayasimachinetest.R
import com.example.praveenpayasimachinetest.data.local.db.DatabaseService
import com.example.praveenpayasimachinetest.data.local.db.entity.UserEntity
import com.example.praveenpayasimachinetest.data.model.User
import com.example.praveenpayasimachinetest.data.remote.NetworkService
import com.example.praveenpayasimachinetest.data.repository.PostRepository
import com.example.praveenpayasimachinetest.data.repository.UserRepository
import com.example.praveenpayasimachinetest.ui.base_emp.BaseItemViewModel
import com.example.praveenpayasimachinetest.ui.users.DeleteUserDialog
import com.example.praveenpayasimachinetest.utils.Entensions
import com.example.praveenpayasimachinetest.utils.log.Logger
import com.example.praveenpayasimachinetest.utils.network.NetworkHelper
import com.example.praveenpayasimachinetest.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserItemViewModel @Inject constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    userRepository: UserRepository,
    private val postRepository: PostRepository,
    private val databaseService: DatabaseService,
    networkService: NetworkService
) : BaseItemViewModel<User>(schedulerProvider, compositeDisposable, networkHelper,databaseService,networkService) {

    companion object {
        const val TAG = "UserItemViewModel"
    }

    /*private val user = userRepository.getCurrentUser()!!
    private val screenWidth = ScreenUtils.getScreenWidth()
    private val screenHeight = ScreenUtils.getScreenHeight()
    private val headers = mapOf(
        Pair(Networking.HEADER_API_KEY, Networking.API_KEY),
        Pair(Networking.HEADER_USER_ID, user.id),
        Pair(Networking.HEADER_ACCESS_TOKEN, user.accessToken)
    )

    val name: LiveData<String> = Transformations.map(data) { it.creator.name }
    val postTime: LiveData<String> = Transformations.map(data) { TimeUtils.getTimeAgo(it.createdAt) }
    val likesCount: LiveData<Int> = Transformations.map(data) { it.likedBy?.size ?: 0 }
    val isLiked: LiveData<Boolean> = Transformations.map(data) {
        it.likedBy?.find { postUser -> postUser.id == user.id } !== null
    }*/

    val name: LiveData<String> = Transformations.map(data) { it.name }
    val id: LiveData<Int> = Transformations.map(data) { it.id}
    val email: LiveData<String> = Transformations.map(data) { it.email }
    val companyName: LiveData<String> = Transformations.map(data) { it.email }
    val city: LiveData<String> = Transformations.map(data) { it.email }



    override fun onCreate() {
        Logger.d(TAG, "onCreate called")
    }

    /*private fun calculateScaleFactor(post: Post) =
        post.imageWidth?.let { return@let screenWidth.toFloat() / it } ?: 1f*/

    /*fun onLikeClick() = data.value?.let {
        if (networkHelper.isNetworkConnected()) {
            val api =
                if (isLiked.value == true)
                    postRepository.makeUnlikePost(it, user)
                else
                    postRepository.makeLikePost(it, user)

            compositeDisposable.add(api
                .subscribeOn(schedulerProvider.io())
                .subscribe(
                    { responsePost -> if (responsePost.id == it.id) updateData(responsePost) },
                    { error -> handleNetworkError(error) }
                )
            )
        } else {
            messageStringId.postValue(Resource.error(R.string.network_connection_error))
        }
    }*/

    fun onUserClick(){
        data.value?.id?.let {
            databaseService.userDao().delete(it)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    Log.e(TAG, "onUserClick: success "+it.toString())
                },{
                    Log.e(TAG, "onUserClick: failure "+it.toString())
                })
        }
    }

}