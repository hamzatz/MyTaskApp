package com.e.mytaskapp.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;


import com.e.mytaskapp.models.Task;


    @Database(entities = {Task.class}, version = 1, exportSchema = false)
    public  abstract class MyDatabase extends RoomDatabase {

        public abstract TaskDao taskDao();

    }


