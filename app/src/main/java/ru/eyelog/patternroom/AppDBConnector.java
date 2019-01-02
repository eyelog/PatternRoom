package ru.eyelog.patternroom;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.persistence.room.Room;

@SuppressLint("Registered")
public class AppDBConnector extends Application {
    public static AppDBConnector instance;
    private AppDatabase database;

    public static AppDBConnector getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database")
                .allowMainThreadQueries()
                .build();
    }

    public AppDatabase getDatabase() {
        return database;
    }
}
