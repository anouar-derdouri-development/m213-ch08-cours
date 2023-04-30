package com.anouarderdouri.m213_ch08_cours;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayDigitFragment extends Fragment {
    private static String[] digitsAr = {"صفر", "واحد", "اثنان", "ثلاثة", "أربعة", "خمسة", "ستة", "سبعة", "ثمانية", "تسعة"};
    private static String[] digitsFr = {"Zéro", "Un", "Deux", "Trois", "Quatre", "Cinq", "Six", "Sept", "Huit", "Neuf"};
    private static String[] digitsEN = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private ConstraintLayout cLayDDF;
    private TextView tvDigit;

    private int value;
    private Lang lang;

    private int bgColor = Color.parseColor("#D8BFD8");

    public void setValue(int value) {
        this.value = value;
        display();
    }

    public void setLang(Lang lang) {
        this.lang = lang;
        display();
    }

    public DisplayDigitFragment() {
        // Required empty public constructor
    }

    public static DisplayDigitFragment newInstance(int value, Lang lang) {
        DisplayDigitFragment fragment = new DisplayDigitFragment();
        Bundle args = new Bundle();
        args.putInt("value", value);
        args.putString("lang", lang.toString());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.value = getArguments().getInt("value");
            this.lang = Lang.valueOf(getArguments().getString("lang"));
        } else {
            this.value = 1;
            this.lang = Lang.EN;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display_digit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cLayDDF = view.findViewById(R.id.cLayDDF);
        tvDigit = view.findViewById(R.id.tvDigit);

        cLayDDF.setBackgroundColor(bgColor);

        display();
    }

    private void display() {
        String[] digits = digitsEN;

        if (this.lang == Lang.AR)
            digits = digitsAr;
        else if (this.lang == Lang.FR)
            digits = digitsFr;

        tvDigit.setText(digits[this.value]);
    }
}