package com.pawelwlazlo.databindinglivedataroomexample.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FirstNameDao {
    @Query("SELECT * FROM FIRST_NAME")
    fun getAllName(): List<FirstName>

    @Insert
    fun insert( firstName: FirstName)

    @Query("SELECT * FROM first_name WHERE id=:id")
    fun loadById(id: Int) : FirstName

    @Query("SELECT COUNT(id) FROM first_name ")
    fun count():Int
}