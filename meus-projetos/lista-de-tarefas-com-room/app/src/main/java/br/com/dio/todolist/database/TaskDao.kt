package br.com.dio.todolist.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface TaskDao {

    // The flow always holds/caches latest version of data. Notifies its observers when the
    // data has changed.
   @Query("SELECT * FROM task_table ORDER BY title ASC")
    fun getAlphabetizedTasks(): Flow<List<Task>>

    @Query("SELECT * FROM task_table")
    suspend fun getAll(): Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(task: Task)

    @Query("DELETE FROM task_table")
    suspend fun deleteAll()
}
