package com.pawelwlazlo.databindinglivedataroomexample.data

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class FirstNameRepository(application: Application) {
    private var firstNameDao: FirstNameDao
    private val _currentFirstName = MutableLiveData<FirstName>()

    init {
        val database: FirstNameDatabase =
            FirstNameDatabase.getFirstNameDatabase(application.applicationContext)!!
        firstNameDao = database.firstNameDao()
        if (firstNameDao.count() == 0) {
            var fn1: FirstName = FirstName(1, "Jan", 3)
            var fn2: FirstName = FirstName(2, "Katarzyna", 9)
            var fn3: FirstName = FirstName(3, "Paweł", 5)

            firstNameDao.insert(fn1)
            firstNameDao.insert(fn2)
            firstNameDao.insert(fn3)
        }

        _currentFirstName.value = firstNameDao.loadById(1)

    }


    val currentFirstName: LiveData<FirstName>
        get() = _currentFirstName

    private fun getRandomFirstName(): FirstName {
        val random = (1..firstNameDao.count()).random()
        return firstNameDao.loadById(random)

    }

    fun changeRandomFirstName() {
        _currentFirstName.value = getRandomFirstName()
    }

    fun addFirstName(name: String, length: Int) {

        var fn = FirstName(name, length)
        firstNameDao.insert(fn)
        _currentFirstName.value = fn

        Log.d("test,", firstNameDao.getAllName().toString())
    }


}