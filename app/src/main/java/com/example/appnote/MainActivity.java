package com.example.appnote;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private EditText editText,editTitle;

    private TextView txt1,txt2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = findViewById(R.id.appwidget_text);

        txt2 = findViewById(R.id.appwidget_title);

        editText = findViewById(R.id.edit_note);
        editTitle = findViewById(R.id.edit_title);
        btn = findViewById(R.id.btn_save);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String noteText = editText.getText().toString();
                String noteTitle = editTitle.getText().toString();
                SharedPreferences preferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);
                preferences.edit().putString("note_Title",noteTitle).apply();
                preferences.edit().putString("note_Text",noteText).apply();
            }
        });

    }
}