package com.example.praveenpayasimachinetest.data.local.db.dao

import androidx.room.*
import com.example.praveenpayasimachinetest.data.local.db.entity.UserEntity
import com.example.praveenpayasimachinetest.data.model.User
import io.reactivex.Single

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): Single<List<User>>

    @Insert
    fun insert(entity: UserEntity): Single<Long>

    @Query("DELETE FROM user WHERE userId = :userId")
    fun delete(userId: Int): Single<Int?>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMany(vararg users: List<UserEntity>): Single<List<User>> // emits the list of users ids added to the database.

}

// /*@Update
// fun update(user: User): Single<Int> // emits an int value, indicating the number of rows updated in the database.
//
// /*@Query("SELECT * FROM user")
// fun getAllEmolyees(): Single<List<UserEntity>>*/
//
// /* @Query("SELECT * from user where isSelected = :isSelected")
// fun getSelectedEmp(isSelected: Boolean): Single<UserEntity>
//
// @Query("SELECT count(*) from user")
// fun count(): Single<Int>*/
// *