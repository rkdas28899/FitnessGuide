package com.example.android.fitnessguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by kmurali on 01-03-2019.
 */

public class DietNormalActivity extends AppCompatActivity {
    private TextView dietnormal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietnormal);
        dietnormal=(TextView)findViewById(R.id.dietnormal);
        String display="The diet you need to follow:"+"\n"+"Fruits & Vegetables"+"\n"+"Calcium Rich & Fat Free Milk"+"\n"+"Yougurt Without added sugars"+
                "\n"+"Grilled Chicken Breast And Fish"+"\n"+"Dry beans"+"\n";
        dietnormal.setText(display);
    }
}
