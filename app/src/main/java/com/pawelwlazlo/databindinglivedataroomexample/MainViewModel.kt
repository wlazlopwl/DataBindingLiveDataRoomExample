package com.pawelwlazlo.databindinglivedataroomexample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.pawelwlazlo.databindinglivedataroomexample.data.FirstName
import com.pawelwlazlo.databindinglivedataroomexample.data.FirstNameRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private var repository = FirstNameRepository(application)
    val newName = MutableLiveData<String>()
    var nameCount= MutableLiveData<Int>()
    val currentFirstName: LiveData<FirstName>
        get() = repository.currentFirstName

    fun changeName(){
        repository.changeRandomFirstName()
    }

    fun addNewName(){
            if(countName(newName.value.toString())>3){
                repository.addFirstName(newName.value.toString(), countName(newName.value.toString()))
            }



    }

    fun countName(newName:String): Int {
        return newName.trim().length
    }


}