package com.pawelwlazlo.databindinglivedataroomexample.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FirstName::class], version = 1)
abstract class FirstNameDatabase : RoomDatabase() {
    abstract fun firstNameDao(): FirstNameDao

    companion object {

        private var instance: FirstNameDatabase? = null

        fun getFirstNameDatabase(context: Context): FirstNameDatabase? {
            if (instance == null) {
                synchronized(FirstNameDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FirstNameDatabase::class.java, "db"
                    )
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return instance
        }
    }

}