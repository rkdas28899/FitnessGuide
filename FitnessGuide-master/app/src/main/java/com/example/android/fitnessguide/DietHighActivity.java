package com.example.android.fitnessguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by kmurali on 01-03-2019.
 */

public class DietHighActivity extends AppCompatActivity {
    private TextView diethigh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diethigh);
        diethigh=(TextView)findViewById(R.id.diethigh);
        String display="You're Overweight"+"\n"+"So you need to follow the following diet"+"\n"+"Eggs"+"\n"+"Diary products"+"\n"+"Honey"+"\n"+"Fruits"+"\n"+"Whole Grains"+"\n"+"Olive Oil"+"\n"+"Pulses"+
                "\n"+"Nuts & Seeds"+"\n"+"Starchy Vegetables"+"\n"+"Chicken Breast"+"\n"+"Solomon & Tuna"+"\n"+
                "Lean Beef"+"\n";
        diethigh.setText(display);
    }
}
