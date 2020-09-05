package com.example.praveenpayasimachinetest.ui.users

import android.os.Bundle
import android.provider.Settings
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.praveenpayasimachinetest.R
import com.example.praveenpayasimachinetest.di.component.ActivityComponent
import com.example.praveenpayasimachinetest.ui.base_emp.BaseActivity
import com.example.praveenpayasimachinetest.ui.users.list_user.UserAdapter
import kotlinx.android.synthetic.main.activity_userlist.*
import javax.inject.Inject

class UserListActivity : BaseActivity<UserListViewModel> () {

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var userAdapter: UserAdapter

    override fun provideLayoutId(): Int  = R.layout.activity_userlist

    override fun injectDependencies(activityComponent: ActivityComponent) {
       activityComponent.inject(this)
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.allUser.observe(this, androidx.lifecycle.Observer {
            it?.run { userAdapter.appendData(this) }
        })

    }

    override fun setupView(savedInstanceState: Bundle?) {
        rvUsers.apply {
            layoutManager = linearLayoutManager
            adapter = userAdapter
            /*addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    layoutManager?.run {
                        if (this is LinearLayoutManager
                            && itemCount > 0
                            && itemCount == findLastVisibleItemPosition() + 1
                        )
                        viewModel.onLoadMore()
                    }
                }
            })*/
        }
    }

    private fun showDeleteDialog(){
        DeleteUserDialog.newInstance(
            getString(R.string.label_delete),
            getString(R.string.msg_delete)
        ).show(supportFragmentManager, DeleteUserDialog.TAG)
    }
}