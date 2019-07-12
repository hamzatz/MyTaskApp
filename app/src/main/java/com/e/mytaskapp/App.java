package com.e.mytaskapp;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.e.mytaskapp.room.MyDatabase;

public class App extends Application {

    private MyDatabase myDatabase;

    public static App instance;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        myDatabase = Room.databaseBuilder(this,
                MyDatabase.class, "mydatabase").
                allowMainThreadQueries().
                build();
    }

    public static App getInstance() {
        return instance;
    }

    public MyDatabase getDatabase()
    {
        return  myDatabase;
    }
}
