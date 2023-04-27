package com.anouarderdouri.m213_ch08_cours;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity {
    EditText etPhone;
    Button btnCall, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        etPhone = findViewById(R.id.etPhone);
        btnCall = findViewById(R.id.btnCall);
        btnClear = findViewById(R.id.btnClear);

        btnClear.setOnClickListener(v -> {
            Intent intent = new Intent(CallActivity.this, ClearActivity.class);
            startActivityForResult(intent, 100);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            etPhone.setText("");
        }
    }
}