package ru.pinigina.messenger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Recieve(View view) {
    }

    public void Send(View view) {
        LinearLayout linearLayout = findViewById(R.id.linearLayoutForConversation);
        EditText editText = findViewById(R.id.editTextForMessage);
        Editable textRaw = editText.getText();
        String text = textRaw.toString();
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

        TextView textView = new TextView(this);
        textView.setText(text);
  //      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams();
        linearLayout.addView(textView);
    }
}
