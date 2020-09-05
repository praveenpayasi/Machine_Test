package com.example.praveenpayasimachinetest.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "user")
 data class UserEntity (@PrimaryKey(autoGenerate = true)
                            @NotNull
                            val id: Long,

                        @ColumnInfo(name = "userId")
                            @NotNull
                            val userId: Int,

                        @ColumnInfo(name = "name")
                            @NotNull
                            val name: String,

                        @ColumnInfo(name = "email")
                            @NotNull
                            val email: String,

                        @ColumnInfo(name = "city")
                            @NotNull
                            val city: String,

                        @ColumnInfo(name = "companyName")
                        @NotNull
                        val companyName: String
                            )

