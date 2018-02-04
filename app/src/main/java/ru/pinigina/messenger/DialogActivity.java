package ru.pinigina.messenger;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gialog);
        ActionBar actionBar = getActionBar();
        actionBar.setTitle("Мама");
    }

    public void Recieve(View view) {
        LinearLayout linearLayout = findViewById(R.id.linearLayoutForConversation);
        EditText editText = findViewById(R.id.editTextForMessage);
        Editable textRaw = editText.getText();
        String text = textRaw.toString();
        editText.setText("");
        //Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

        TextView textView = new TextView(this);
        textView.setText(text);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.LEFT;
        linearLayout.addView(textView, layoutParams);
    }

    public void Send(View view) {
        LinearLayout linearLayout = findViewById(R.id.linearLayoutForConversation);
        EditText editText = findViewById(R.id.editTextForMessage);
        Editable textRaw = editText.getText();
        String text = textRaw.toString();
        editText.setText("");

        TextView textView = new TextView(this);
        textView.setText(text);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.RIGHT;
        linearLayout.addView(textView, layoutParams);
    }
}
