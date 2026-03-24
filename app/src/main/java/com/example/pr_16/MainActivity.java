package com.example.pr_16;

import android.content.SharedPreferences;
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

    // Константы для SharedPreferences
    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_SAVED_TEXT = "savedText";

    private String savedText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация элементов
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);

        // Загружаем сохранённый текст из SharedPreferences при старте
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        savedText = prefs.getString(KEY_SAVED_TEXT, "");

        // (Опционально) можно сразу отобразить сохранённый текст в TextView
        textView.setText(savedText);

        // Обработчик для кнопки Save
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получаем текст из поля ввода
                String textToSave = editText.getText().toString();

                // Сохраняем в SharedPreferences
                SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
                editor.putString(KEY_SAVED_TEXT, textToSave);
                editor.apply();  // асинхронное сохранение

                // Обновляем переменную savedText
                savedText = textToSave;

                // Можно очистить поле ввода после сохранения (по желанию)
                // editText.setText("");
            }
        });

        // Обработчик для кнопки Load
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Загружаем текст из SharedPreferences на момент нажатия
                SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
                String loadedText = prefs.getString(KEY_SAVED_TEXT, "");
                textView.setText(loadedText);

                // Также обновляем savedText, чтобы он соответствовал последнему сохранённому
                savedText = loadedText;
            }
        });
    }
}