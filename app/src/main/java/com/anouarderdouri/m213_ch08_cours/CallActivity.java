package com.anouarderdouri.m213_ch08_cours;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity {
    public static final int CLEAR_REQUEST = 1;
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
            startActivityForResult(intent, CLEAR_REQUEST);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CLEAR_REQUEST) {
            if (resultCode == RESULT_OK) {
                etPhone.setText("");
            }
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(CallActivity.this);

        builder.setTitle("Attention")
                .setMessage("Are you sure?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        CallActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}