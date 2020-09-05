package com.example.praveenpayasimachinetest

import android.app.Application
import com.example.praveenpayasimachinetest.di.component.ApplicationComponent
import com.example.praveenpayasimachinetest.di.component.DaggerApplicationComponent
import com.example.praveenpayasimachinetest.di.module.ApplicationModule

class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}