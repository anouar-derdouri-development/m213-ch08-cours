package com.anouarderdouri.m213_ch08_cours;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DigitsActivity extends AppCompatActivity implements NumericUpDownFragment.OnValueChanged {
    NumericUpDownFragment numericUpDownFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digits);

        numericUpDownFragment = new NumericUpDownFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fLayNumericUpDown, numericUpDownFragment, null)
                .commit();

    }

    @Override
    public void onChanged() {
        int digit = numericUpDownFragment.getValue();


    }
}