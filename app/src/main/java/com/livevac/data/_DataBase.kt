package com.livevac.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.livevac.data.animals.Animal
import com.livevac.data.animals.AnimalDao

@Database(entities = [Animal::class], version = 1)
abstract class DataBase: RoomDatabase() {

    abstract fun AnimalDao(): AnimalDao

    companion object{
        @Volatile
        private var INSTANCE: DataBase? = null

        fun getDatabase(context: Context): DataBase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,
                    "database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}