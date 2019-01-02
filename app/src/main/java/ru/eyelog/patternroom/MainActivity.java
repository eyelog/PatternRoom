package ru.eyelog.patternroom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDatabase appDatabase;
    UserDao userDao;

    TextView textView;
    EditText editText;
    Button button, button01;
    ListView listView;

    List<User> users;
    ArrayList<String> parsedUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        button01 = findViewById(R.id.button01);
        listView = findViewById(R.id.listView);

        appDatabase = AppDBConnector.getInstance().getDatabase();
        userDao = appDatabase.userDao();

        button.setOnClickListener((v) -> {
            userDao.insert(new User(editText.getText().toString()));
        });

        button01.setOnClickListener((v) -> {
            users = userDao.getAll();
            parsedUsers = new ArrayList<>();
            for (User user : users) {
                parsedUsers.add(user.getName());
            }
            listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, parsedUsers));
        });
    }
}
