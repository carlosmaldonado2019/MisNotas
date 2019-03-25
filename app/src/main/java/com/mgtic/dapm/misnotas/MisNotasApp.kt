package com.mgtic.dapm.misnotas

import android.app.Application
import android.arch.persistence.room.Room
import com.mgtic.dapm.misnotas.database.TaskDatabase

class MisNotasApp: Application(){
    companion object {
        lateinit var database: TaskDatabase
    }

    override fun onCreate() {
        super.onCreate()
        MisNotasApp.database = Room.databaseBuilder(
            this,TaskDatabase::class.java,"tasks-db").build()
    }
}