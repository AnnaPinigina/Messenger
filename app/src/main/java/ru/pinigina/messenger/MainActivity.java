package ru.pinigina.messenger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DataBaseHelper dataBaseHelper = new DataBaseHelper(this, "database.db", null, 1);
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

        getUser();
    }
}
