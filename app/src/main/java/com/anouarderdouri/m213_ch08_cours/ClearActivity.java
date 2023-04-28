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
            // https://stackoverflow.com/questions/5104269/using-startactivityforresult-how-to-get-requestcode-in-child-activity#:~:text=The%20request%20code%20is%20not%20passed%20to%20the%20started%20activity%20automatically%20because%20it%20doesn%27t%20(and%20shouldn%27t)%20need%20to%20know%20this%20value.%20It%20only%20needs%20to%20know%20what%20to%20do%20and%20not%20where%20it%20was%20started%20from.
            setResult(RESULT_OK, null);
            finish();
        });

        btnNo.setOnClickListener(v -> {
            setResult(RESULT_CANCELED, null);
            finish();
        });
    }
}