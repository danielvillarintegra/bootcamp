package br.com.danielvillarintegra.businesscard.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BusinessCardDao {

    @Query("SELECT * FROM BusinessCard")
    fun getAll(): LiveData<List<BusinessCard>>

    @Query("SELECT * FROM BusinessCard WHERE id=:id")
    fun buscarContato(id:Int?): LiveData<List<BusinessCard>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(businessCard: BusinessCard)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun update(businessCard: BusinessCard)

    @Delete
    suspend fun delete(businessCard: BusinessCard)

}