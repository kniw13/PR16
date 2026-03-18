package com.example.pr_16;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    private Button btnSave, btnLoad;

    private String savedText = ""; // переменная для хранения сохранённого текста

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация элементов
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);

        // Обработчик для кнопки Save
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedText = editText.getText().toString();
                // Можно показать уведомление или очистить поле (опционально)
                // editText.setText("");
            }
        });

        // Обработчик для кнопки Load
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(savedText);
            }
        });
    }
}