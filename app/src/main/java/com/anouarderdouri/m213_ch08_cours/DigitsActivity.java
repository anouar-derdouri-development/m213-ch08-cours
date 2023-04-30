package com.anouarderdouri.m213_ch08_cours;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DigitsActivity extends AppCompatActivity {
    NumericUpDownFragment numericUpDownFragment;
    TextView tvDigit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digits);

        tvDigit = findViewById(R.id.tvDigit);

        numericUpDownFragment = new NumericUpDownFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fLayNumericUpDown, numericUpDownFragment, null)
                .commit();

        findViewById(R.id.btnShow).setOnClickListener(v -> {
            int digit = numericUpDownFragment.getValue();

            String[] digits = getResources().getStringArray(R.array.digits);

            tvDigit.setText(digits[digit]);
        });

    }
}