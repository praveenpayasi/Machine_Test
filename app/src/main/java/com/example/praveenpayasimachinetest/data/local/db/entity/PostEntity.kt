package com.example.praveenpayasimachinetest.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "post")
 data class PostEntity (@PrimaryKey(autoGenerate = true)
                            @NotNull
                            val id: Long,

                        @ColumnInfo(name = "postId")
                            @NotNull
                            val postId: Int,

                        @ColumnInfo(name = "userId")
                            @NotNull
                            val userId: Int,

                        @ColumnInfo(name = "title")
                            @NotNull
                            val title: String,

                        @ColumnInfo(name = "body")
                            @NotNull
                            val body: String
                            )

