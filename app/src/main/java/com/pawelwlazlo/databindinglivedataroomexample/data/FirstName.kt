package com.pawelwlazlo.databindinglivedataroomexample.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "first_name")
data class FirstName(
    @PrimaryKey(autoGenerate = true) var id:Int ,
    var name: String,
    var numOfChar:Int
) {
    constructor(name: String, numOfChar: Int): this(0,name,numOfChar)
}