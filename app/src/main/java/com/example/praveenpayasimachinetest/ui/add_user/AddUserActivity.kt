package com.example.praveenpayasimachinetest.ui.add_user

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.Observer
import com.example.praveenpayasimachinetest.MainActivity
import com.example.praveenpayasimachinetest.R
import com.example.praveenpayasimachinetest.di.component.ActivityComponent
import com.example.praveenpayasimachinetest.ui.base_emp.BaseActivity
import com.example.praveenpayasimachinetest.ui.users.UserListActivity
import com.example.praveenpayasimachinetest.utils.Event
import com.example.praveenpayasimachinetest.utils.Status

import kotlinx.android.synthetic.main.activity_add_emp.*

class AddUserActivity : BaseActivity<AddUserViewModel>()  {
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }*/

    override fun setupObservers() {
        super.setupObservers()
        setupObserver()
    }

    override fun goBack() {
        super.goBack()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun provideLayoutId(): Int = R.layout.activity_add_emp

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {

        et_name.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.onNameChange(p0.toString())
            }
        })

        et_id.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.onIdChange(p0.toString())
            }

        })

        et_email.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.onEmailChange(p0.toString())
            }

        })

        bt_Add.setOnClickListener(View.OnClickListener { viewModel.onAddClicked() })

    }

    fun setupObserver(){

        viewModel.launchMain.observe(this, Observer<Event<Map<String, String>>>{
            it.getIfNotHandled()?.run {
                startActivity(Intent(applicationContext, UserListActivity::class.java))
                finish()
            }
        })

        viewModel.nameField.observe(this, Observer {
            if (et_name.text.toString() != it) et_name.setText(it)
        })

        viewModel.nameValidation.observe(this, Observer {
            when(it.status){
                Status.ERROR -> layout_name.error = it.data?.run { getString(this) }
                else-> layout_name.isErrorEnabled = false
            }


        })

        viewModel.idField.observe(this, Observer {
            if (et_id.text.toString() != it) et_id.setText(it)
        })


        viewModel.idValidation.observe(this, Observer {
            when(it.status){
                Status.ERROR -> layout_id.error = it.data?.run { getString(this) }
                else -> layout_id.isErrorEnabled = false
            }
        })
        viewModel.emailField.observe(this, Observer {
            if (et_email.text.toString() != it) et_email.setText(it)
        })


        viewModel.emailValidation.observe(this, Observer {
            when(it.status){
                Status.ERROR -> layout_email.error = it.data?.run { getString(this) }
                else -> layout_email.isErrorEnabled = false
            }
        })

        bt_Add.setOnClickListener(View.OnClickListener { viewModel.onAddClicked() })
    }
}