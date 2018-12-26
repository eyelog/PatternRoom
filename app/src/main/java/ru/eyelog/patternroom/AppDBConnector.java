package ru.eyelog.patternroom;

import android.app.Application;
import android.arch.persistence.room.Room;

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
        database = Room.databaseBuilder(this, AppDatabase.class, "database")
                .allowMainThreadQueries()
                .build();
    }

    public AppDatabase getDatabase() {
        return database;
    }
}
