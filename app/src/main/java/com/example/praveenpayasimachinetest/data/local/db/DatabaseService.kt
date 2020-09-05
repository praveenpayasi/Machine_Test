package com.example.praveenpayasimachinetest.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.praveenpayasimachinetest.data.local.db.dao.PostDao
import com.example.praveenpayasimachinetest.data.local.db.dao.UserDao
import com.example.praveenpayasimachinetest.data.local.db.entity.PostEntity
import com.example.praveenpayasimachinetest.data.local.db.entity.UserEntity
import javax.inject.Singleton

@Singleton
@Database(
    entities = [
        UserEntity::class,
        PostEntity::class
    ],
    exportSchema = false,
    version = 1
)
abstract class DatabaseService : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun postDao() : PostDao
}