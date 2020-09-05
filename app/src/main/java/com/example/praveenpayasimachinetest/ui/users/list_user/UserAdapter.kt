package com.example.praveenpayasimachinetest.ui.users.list_user

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.example.praveenpayasimachinetest.data.model.User
import com.example.praveenpayasimachinetest.ui.base_emp.BaseAdapter

class UserAdapter(
    parentLifecycle: Lifecycle,
    posts: ArrayList<User>
) : BaseAdapter<User, UserItemViewHolder>(parentLifecycle, posts) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserItemViewHolder(parent)
}