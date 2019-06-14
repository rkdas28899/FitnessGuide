package com.example.android.fitnessguide;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


public class BMIActivity extends AppCompatActivity {

    private AppCompatActivity activity = BMIActivity.this;
    private AppCompatTextView textViewName;
    private RecyclerView recyclerViewUsers;
    private List<User> listUsers;
    private UsersRecyclerAdapter usersRecyclerAdapter;
    private DatabaseHelper databaseHelper;
    private TextInputEditText height,weight;
    private Button calculate,proceed;
    private TextView displaybmi;
    private String status;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
        calculate=(Button)findViewById(R.id.calculate);
        proceed=(Button)findViewById(R.id.proceed);
        getSupportActionBar().setTitle("");
        initViews();
        initObjects();
        height=(TextInputEditText)findViewById(R.id.heightedittext);
        weight=(TextInputEditText)findViewById(R.id.weightedittext);
        displaybmi=(TextView)findViewById(R.id.display_bmi);

        calculate.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {

                                             final String he=height.getText().toString();
                                             final String we=weight.getText().toString();
                                             final int h=Integer.parseInt(he);
                                             final int w=Integer.parseInt(we);
                                             final float bmi=(w*100*100)/(h*h);
                                             if(bmi<18.5){
                                                 status="Low";
                                             }
                                             else if(bmi>18.5&&bmi<24.9){
                                                 status="Normal";
                                             }
                                             else{
                                                 status="High";
                                             }
                                             displaybmi.setText("Your BMI is " + bmi + "(" + status + ")");
                                         }
                                     });

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(BMIActivity.this,OptionsActivity.class);
                i.putExtra("status",status);
                startActivity(i);
            }
        });


    }

    /**
     * This method is to initialize views
     */
    private void initViews() {
        textViewName = (AppCompatTextView) findViewById(R.id.textViewName);

    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {

        databaseHelper = new DatabaseHelper(activity);

        String emailFromIntent = getIntent().getStringExtra("EMAIL");
        textViewName.setText(emailFromIntent);

      //  getDataFromSQLite();
    }

    /**
     * This method is to fetch all user records from SQLite
     */
    private void getDataFromSQLite() {
        // AsyncTask is used that SQLite operation not blocks the UI Thread.
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                listUsers.clear();
                listUsers.addAll(databaseHelper.getAllUser());

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                usersRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }
}
