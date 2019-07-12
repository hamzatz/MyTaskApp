package com.e.mytaskapp.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.e.mytaskapp.models.Task;

import java.util.List;
    @Dao
    public interface TaskDao {


        @Query("SELECT * FROM Task ORDER by id DESC")
        LiveData<List<Task>> getAll();

        @Query("SELECT * FROM Task WHERE id = :id")
        Task getById (long id);

        @Update
        void update (Task task);

        @Insert
        void insert(Task task);

        @Delete
        void delete(Task task);


    }


