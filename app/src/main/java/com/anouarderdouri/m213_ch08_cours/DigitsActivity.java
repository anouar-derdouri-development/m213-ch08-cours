package com.anouarderdouri.m213_ch08_cours;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class DigitsActivity extends AppCompatActivity implements NumericUpDownFragment.OnValueChanged {
    NumericUpDownFragment numericUpDownFragment;
    DisplayDigitFragment displayDigitFragment;
    RadioButton rdAr, rdFr, rdEn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digits);

        rdAr = findViewById(R.id.rdAr);
        rdFr = findViewById(R.id.rdFr);
        rdEn = findViewById(R.id.rdEn);

        rdAr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) displayDigitFragment.setLang(Lang.AR);
            }
        });

        rdFr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) displayDigitFragment.setLang(Lang.FR);
            }
        });

        rdEn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) displayDigitFragment.setLang(Lang.EN);
            }
        });

        numericUpDownFragment = new NumericUpDownFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fLayNumericUpDown, numericUpDownFragment, null)
                .commit();

        Lang lang = rdAr.isChecked() ? Lang.AR : (rdFr.isChecked() ? Lang.FR : Lang.EN);
        displayDigitFragment = DisplayDigitFragment.newInstance(numericUpDownFragment.getValue(), lang);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fcvDigit, displayDigitFragment, null)
                .commit();
    }

    @Override
    public void onChanged() {
        int digit = numericUpDownFragment.getValue();

        displayDigitFragment.setValue(digit);
    }
}