package com.anouarderdouri.m213_ch08_cours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ClearActivity extends AppCompatActivity {
    Button btnYes, btnNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clear);

        btnYes = findViewById(R.id.btnYes);
        btnNo = findViewById(R.id.btnNo);

        btnYes.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("response", true);
            setResult(RESULT_OK, intent);
            finish();
        });

        btnNo.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("response", false);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}