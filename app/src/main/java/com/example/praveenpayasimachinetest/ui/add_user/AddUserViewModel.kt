package com.example.praveenpayasimachinetest.ui.add_user

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.praveenpayasimachinetest.data.local.db.DatabaseService
import com.example.praveenpayasimachinetest.data.local.db.entity.UserEntity
import com.example.praveenpayasimachinetest.data.remote.NetworkService
import com.example.praveenpayasimachinetest.data.repository.PostRepository
import com.example.praveenpayasimachinetest.data.repository.UserRepository
import com.example.praveenpayasimachinetest.ui.base_emp.BaseViewModel
import com.example.praveenpayasimachinetest.utils.*
import com.example.praveenpayasimachinetest.utils.network.NetworkHelper
import com.example.praveenpayasimachinetest.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AddUserViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    userRepository: UserRepository,
    postRepository: PostRepository,
    val databaseService: DatabaseService,
    networkService: NetworkService
) : BaseViewModel(schedulerProvider = schedulerProvider,
    compositeDisposable = compositeDisposable,
    networkHelper = networkHelper,
    networkService = networkService
    ){

    companion object {
        const val TAG = "AddEmployeeViewModel"
    }

    val nameField: MutableLiveData<String> = MutableLiveData()
    val idField : MutableLiveData<String> = MutableLiveData()
    val emailField : MutableLiveData<String> = MutableLiveData()

    val launchMain : MutableLiveData<Event<Map<String, String>>> = MutableLiveData()

    val validationsList : MutableLiveData<List<Validation>> = MutableLiveData()
    val nameValidation: LiveData<Resource<Int>> = filterValidation(Validation.Field.NAME)
    val idValidation: LiveData<Resource<Int>> = filterValidation(Validation.Field.ID)
    val emailValidation: LiveData<Resource<Int>> = filterValidation(Validation.Field.EMAIL)

    private fun filterValidation(field: Validation.Field) =
        Transformations.map(validationsList) {
            it.find { validation -> validation.field == field }
                ?.run { return@run this.resource }
                ?: Resource.unknown()
        }

    override fun onCreate() {}

    fun onNameChange(name:String) = nameField.postValue(name)

    fun onIdChange(id : String) = idField.postValue(id)

    fun onEmailChange(email : String) = emailField.postValue(email)

    fun onAddClicked(){

        val name = nameField.value
        val id = idField.value
        val email = emailField.value

        val validations =
            Validator.validateAddUserFields(
                name, email, id)
        validationsList.postValue(validations)
        if (validations.isNotEmpty() && name != null && id != null && email != null) {
            val successValidation = validations.filter { it.resource.status == Status.SUCCESS }
            if (successValidation.size == validations.size) {
                addEmployee(name,id,email)
            }

        }
    }

    private fun addEmployee(name:String, salary: String, designation: String) {
        compositeDisposable.add(
            databaseService.userDao()
                .insert(UserEntity(0,10,name,designation,salary,""))
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        //UserEntity = it
                        Log.e(TAG, "addEmployee: "+it.toString())
                        launchMain.postValue(Event(emptyMap()))
                        //allUser.postValue(it)
                    },
                    {
                        Log.d(TAG, it.toString())
                    }
                )
        )
    }

    /*init {
        // add dummy users in the database
        compositeDisposable.add(
            databaseService.userDao()
                .count()
                .flatMap {
                    if (it == 0)
                        databaseService
                            .addressDao()
                            .insertMany(
                                Address(city = "Delhi", country = "India", code = 1),
                                Address(city = "New York", country = "US", code = 2),
                                Address(city = "Berlin", country = "Germany", code = 3),
                                Address(city = "London", country = "UK", code = 4),
                                Address(city = "Bangalore", country = "India", code = 5),
                                Address(city = "Barcelona", country = "Spain", code = 6)
                            )
                            .flatMap { addressIds ->
                                databaseService
                                    .userDao()
                                    .insertMany(
                                        User(name = "Test 1", addressId = addressIds[0], dateOfBirth = Date(959684579)),
                                        User(name = "Test 1", addressId = addressIds[1], dateOfBirth = Date(959684579)),
                                        User(name = "Test 1", addressId = addressIds[2], dateOfBirth = Date(959684579)),
                                        User(name = "Test 1", addressId = addressIds[3], dateOfBirth = Date(959684579)),
                                        User(name = "Test 1", addressId = addressIds[4], dateOfBirth = Date(959684579)),
                                        User(name = "Test 1", addressId = addressIds[5], dateOfBirth = Date(959684579))
                                    )
                            }

                    else Single.just(0)
                }
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        Log.d(TAG, "Users present in db $it")
                    },
                    {
                        Log.d(TAG, it.toString())
                    }
                )
        )

    }

    fun addEmployee(name:String,salary: String,designation: String) {
        compositeDisposable.add(
            databaseService.employeeDao()
                .insert(UserEntity(0,name,designation,salary,false))
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        UserEntity = it
                        allUser.postValue(it)
                    },
                    {
                        Log.d(TAG, it.toString())
                    }
                )
        )
    }*/
    fun onDestroy() {
        compositeDisposable.clear()
    }

}

