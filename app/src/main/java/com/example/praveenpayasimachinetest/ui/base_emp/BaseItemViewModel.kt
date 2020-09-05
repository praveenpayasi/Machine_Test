package com.example.praveenpayasimachinetest.ui.base_emp

import androidx.lifecycle.MutableLiveData
import com.example.praveenpayasimachinetest.data.local.db.DatabaseService
import com.example.praveenpayasimachinetest.data.remote.NetworkService
import com.example.praveenpayasimachinetest.utils.network.NetworkHelper
import com.example.praveenpayasimachinetest.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable


abstract class BaseItemViewModel<T : Any>(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    databaseService: DatabaseService,
    networkService: NetworkService
) : BaseViewModel(schedulerProvider,compositeDisposable,networkHelper,networkService) {

    val data: MutableLiveData<T> = MutableLiveData()

    fun onManualCleared() = onCleared()

    fun updateData(data: T) {
        this.data.postValue(data)
    }
}