package com.example.praveenpayasimachinetest.data.repository

import com.example.praveenpayasimachinetest.data.local.db.DatabaseService
import com.example.praveenpayasimachinetest.data.model.User
import com.example.praveenpayasimachinetest.data.remote.NetworkService
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val networkService: NetworkService,
    private val databaseService: DatabaseService
) {

    /*fun saveCurrentUser(user: User) {
        userPreferences.setUserId(user.id)
        userPreferences.setUserName(user.name)
        userPreferences.setUserEmail(user.email)
        userPreferences.setAccessToken(user.accessToken)
    }

    fun removeCurrentUser() {
        userPreferences.removeUserId()
        userPreferences.removeUserName()
        userPreferences.removeUserEmail()
        userPreferences.removeAccessToken()
    }

    fun getCurrentUser(): User? {

        val userId = userPreferences.getUserId()
        val userName = userPreferences.getUserName()
        val userEmail = userPreferences.getUserEmail()
        val accessToken = userPreferences.getAccessToken()

        return if (userId !== null && userName != null && userEmail != null && accessToken != null)
            User(userId, userName, userEmail, accessToken)
        else
            null
    }*/

    fun doUserCall(): Single<List<User>> {
        return networkService.getUsers().map {
            it
        }
    }


    /*fun doRegisterCall(name :String,password: String,email:String):Single<User> =
        networkService.doSignUpCall(SignUpRequest(email, password, name)).map {
            User(
                it.userName,
                it.accessToken,
                it.userEmail,
                it.accessToken,
                it.profilePicUrl
            )
        }*/

}
