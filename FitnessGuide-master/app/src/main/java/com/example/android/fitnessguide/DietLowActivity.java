package com.example.android.fitnessguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by kmurali on 01-03-2019.
 */

public class DietLowActivity extends AppCompatActivity {
    private TextView dietlow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietlow);
        dietlow=(TextView)findViewById(R.id.dietlow);
        String display="You're Underweight"+"\n"+"So you need to follow the following diet"+"\n"+"Wallnut"+"\n"+"Peanuts"+"\n"+"ALmonds & nuts"+
                "\n"+"Dates and Donuts"+"\n"+"High Carbs & High Fats"+"\n"+"Whole Milk"+"\n"+"Yogurt"+"\n"+"Cheese"+"\n"+"Cream"+"\n"+"olive oil"+
                "\n"+"Whole Grains"+"\n"+"Oats & Brown Rice"+"\n"+"Potatoes & Sweat Potatoes"+"\n"+"Chicken"+"\n"+"Mutton And Beef"+"\n"+"Pork & Lamb"+"\n";
        dietlow.setText(display);
    }
}
