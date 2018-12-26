package ru.eyelog.patternroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDatabase appDatabase;
    UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase = AppDBConnector.getInstance().getDatabase();
        userDao = appDatabase.userDao();
    }

    public void createUser(){
        User user = new User("name", true);
        userDao.insert(user);
    }

    public void getUsers(){
        List<User> users = userDao.getAll();
    }
}
