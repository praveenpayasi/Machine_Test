package com.example.praveenpayasimachinetest.di.module

import androidx.lifecycle.LifecycleRegistry
import com.example.praveenpayasimachinetest.di.ViewModelScope
import com.example.praveenpayasimachinetest.ui.base_emp.BaseItemViewHolder
import dagger.Module
import dagger.Provides

@Module
class ViewHolderModule(private val viewHolder: BaseItemViewHolder<*, *>) {

    @Provides
    @ViewModelScope
    fun provideLifecycleRegistry(): LifecycleRegistry = LifecycleRegistry(viewHolder)


}