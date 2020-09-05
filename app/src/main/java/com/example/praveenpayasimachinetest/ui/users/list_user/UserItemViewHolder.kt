package com.example.praveenpayasimachinetest.ui.users.list_user

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import com.example.praveenpayasimachinetest.R
import com.example.praveenpayasimachinetest.data.model.User
import com.example.praveenpayasimachinetest.di.component.ViewHolderComponent
import com.example.praveenpayasimachinetest.ui.base_emp.BaseItemViewHolder
import com.example.praveenpayasimachinetest.utils.Toaster
import kotlinx.android.synthetic.main.delete_confirm_dialog.view.*
import kotlinx.android.synthetic.main.item_view_users.view.*

class UserItemViewHolder(parent: ViewGroup) :
    BaseItemViewHolder<User, UserItemViewModel>(R.layout.item_view_users, parent) {

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) {
        viewHolderComponent.inject(this)
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.name.observe(this, Observer {
            itemView.tv_name.text = it
        })

        viewModel.id.observe(this, Observer {
            itemView.tv_id.text = it.toString()
        })

        viewModel.email.observe(this, Observer {
            itemView.tv_email.text = it
        })

        viewModel.companyName.observe(this, Observer {
            itemView.tv_companyName.text = it.toString()
        })

        viewModel.city.observe(this, Observer {
            itemView.tv_city.text = it
        })

    }

    override fun setupView(view: View) {
        itemView.layout_user.setOnClickListener { viewModel.onUserClick() }
    }

}