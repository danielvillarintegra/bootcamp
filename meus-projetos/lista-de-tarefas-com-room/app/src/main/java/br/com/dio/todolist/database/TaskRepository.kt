package br.com.dio.todolist.database


import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import br.com.dio.todolist.database.Task
import br.com.dio.todolist.database.TaskDao
import kotlinx.coroutines.flow.Flow


class TaskRepository(private val taskDao: TaskDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
     val allTasks: Flow<List<Task>> = taskDao.getAlphabetizedTasks()


    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertTask(task: Task) {
        taskDao.insert(task)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteTask(task: Task) {
        taskDao.deleteAll()
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getAll() {
        //taskDao.getAlphabetizedTasks() }
        taskDao.getAll()
    }


}

