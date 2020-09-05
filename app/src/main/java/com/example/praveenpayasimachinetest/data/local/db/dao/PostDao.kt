package com.example.praveenpayasimachinetest.data.local.db.dao

import androidx.room.*
import com.example.praveenpayasimachinetest.data.local.db.entity.PostEntity
import com.example.praveenpayasimachinetest.data.local.db.entity.UserEntity
import com.example.praveenpayasimachinetest.data.model.Post
import com.example.praveenpayasimachinetest.data.model.User
import io.reactivex.Single

@Dao
interface PostDao {

    @Query("SELECT * FROM post")
    fun getAll(): List<PostEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: PostEntity) : Single<Long>

    @Delete
    fun delete(entity: PostEntity)

    @Update
    fun update(post: PostEntity)//: Single<Int> // emits an int value, indicating the number of rows updated in the database.

   /* @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMany(vararg posts: PostEntity): Single<List<Long>> // emits the list of users ids added to the database.*/

    /*@Query("SELECT * FROM post")
    fun getAllEmolyees(): Single<List<UserEntity>>

    @Query("SELECT * from post where isSelected = :isSelected")
    fun getSelectedEmp(isSelected: Boolean): Single<UserEntity>

    @Query("SELECT count(*) from post")
    fun count(): Single<Int>*/

}