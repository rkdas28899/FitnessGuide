package com.example.android.fitnessguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by kmurali on 01-03-2019.
 */

public class OptionsActivity extends AppCompatActivity {
    Button run,diet,workout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        run=(Button)findViewById(R.id.letsstart);
        diet=(Button)findViewById(R.id.gotodiet);
        workout=(Button)findViewById(R.id.workout);
        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(OptionsActivity.this,AccelerometerActivity.class);
                startActivity(i);
            }
        });
        diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String status=getIntent().getStringExtra("status");
                if(status.equals("Low")){
                        Intent i=new Intent(OptionsActivity.this,DietLowActivity.class);
                        startActivity(i);
                }
                else if(status.equals("Normal")){
                    Intent i=new Intent(OptionsActivity.this,DietNormalActivity.class);
                    startActivity(i);
                }
                else{
                    Intent i=new Intent(OptionsActivity.this,DietHighActivity.class);
                    startActivity(i);
                }
            }
        });

        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String status=getIntent().getStringExtra("status");
                if(status.equals("Low")){
                    Toast.makeText(getApplicationContext(),"No workouts available",Toast.LENGTH_SHORT).show();
                }
                else if(status.equals("Normal")){
                    Intent i=new Intent(OptionsActivity.this,WorkoutNormalActivity.class);
                    startActivity(i);
                }
                else{
                    Intent i=new Intent(OptionsActivity.this,WorkoutHighActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}
