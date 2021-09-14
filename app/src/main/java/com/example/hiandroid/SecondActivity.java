package com.example.hiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        backButton = findViewById(R.id.back_button);

        backButton.setOnClickListener(v -> {
            setContentView(R.layout.activity_main);
            //startActivity (new Intent(getApplicationContext(), MainActivity.class));

            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent); // С мейн на секонд переключается по клику на кнопке, а обратно на Мейн не хочет. Почему?
        });
    }
}