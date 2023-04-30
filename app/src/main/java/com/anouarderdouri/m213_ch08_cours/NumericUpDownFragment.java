package com.anouarderdouri.m213_ch08_cours;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class NumericUpDownFragment extends Fragment {
    private Button btnDecrement, btnIncrement;
    private TextView tvValue;

    private  int min = 0;
    private int max = 9;

    public int getValue() {
        return value;
    }

    private int value = min;

    public NumericUpDownFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_numeric_up_down, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnDecrement = view.findViewById(R.id.btnDecrement);
        btnIncrement = view.findViewById(R.id.btnIncrement);
        tvValue = view.findViewById(R.id.tvValue);

        tvValue.setText(Integer.toString(value));

        btnDecrement.setOnClickListener(v -> {
            if (value > min) {
                value--;
                tvValue.setText(Integer.toString(value));
            }
        });

        btnIncrement.setOnClickListener(v -> {
            if (value < max) {
                value++;
                tvValue.setText(Integer.toString(value));
            }
        });
    }

}