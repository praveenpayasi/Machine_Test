package com.example.praveenpayasimachinetest.di.component

import com.example.praveenpayasimachinetest.di.ViewModelScope
import com.example.praveenpayasimachinetest.di.module.ViewHolderModule
import com.example.praveenpayasimachinetest.ui.users.list_user.UserItemViewHolder
import dagger.Component

@ViewModelScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ViewHolderModule::class]
)
interface ViewHolderComponent {

    //fun inject(viewHolder: DummyItemViewHolder)

    fun inject(viewHolder: UserItemViewHolder)
}