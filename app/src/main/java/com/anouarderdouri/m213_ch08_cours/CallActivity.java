package com.anouarderdouri.m213_ch08_cours;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity {
    public static final int CLEAR_REQUEST = 1;
    EditText etPhone;
    Button btnCall, btnClear;

    ActivityResultLauncher<Intent> confirmClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        etPhone = findViewById(R.id.etPhone);
        btnCall = findViewById(R.id.btnCall);
        btnClear = findViewById(R.id.btnClear);

        confirmClear = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            Intent data = result.getData();

                            if (data.getBooleanExtra("response", false))
                                etPhone.setText("");
                        }
                    }
                }
        );

        btnClear.setOnClickListener(v -> {
            Intent intent = new Intent(CallActivity.this, ClearActivity.class);
            confirmClear.launch(intent);
        });

        btnCall.setOnClickListener(v -> {
            String phone = etPhone.getText().toString();

            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(String.format("tel:%s", phone)));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else Toast.makeText(this, "Sorry!!!", Toast.LENGTH_SHORT).show();

            /*
                Common Intents: https://developer.android.com/guide/components/intents-common
             */
        });
    }
}