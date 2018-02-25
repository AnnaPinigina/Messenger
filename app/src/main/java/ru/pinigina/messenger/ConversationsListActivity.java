package ru.pinigina.messenger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ConversationsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversations_list);

//        ArrayList<String> Conversations = new ArrayList<String>();
//        Conversations.add("Mum");
//        Conversations.add("Dad");

        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
        ArrayList<String> users = dataBaseHelper.getListOfUsers();

        ListView listView = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, users);
        listView.setAdapter(adapter);

    }
}
