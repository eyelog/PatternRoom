package ru.eyelog.patternroom;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey
    public int id;
    public String name;
    public boolean status;

    public User(String name, boolean status) {
        this.name = name;
        this.status = status;
    }
}
