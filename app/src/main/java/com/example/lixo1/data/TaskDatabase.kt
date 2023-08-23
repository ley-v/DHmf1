package com.example.lixo1.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.lixo1.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider


@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase(){

    abstract fun taskDao(): TaskDao

}
//    class Callback @Inject constructor(
    class Callback (
//        private val database: Provider<TaskDatabase>,
//        @ApplicationScope private val applicationScope: CoroutineScope
        private val database: TaskDatabase,
        private val applicationScope: CoroutineScope
    ): RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val dao = database.taskDao()
            applicationScope.launch {
                dao.insert(Task(name = "f mt"))
                dao.insert(Task(name = "f alv", important = true))
                dao.insert(Task(name = "f suzu"))
                dao.insert(Task(name = "f violet", completed = true))
            }
        }
    }
