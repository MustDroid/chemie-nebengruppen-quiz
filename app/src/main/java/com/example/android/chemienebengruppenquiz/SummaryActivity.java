package com.example.android.chemienebengruppenquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("score");

        if(score >= 12) {
            Toast.makeText(SummaryActivity.this, "Deine Note ist : 1", Toast.LENGTH_LONG).show();
        }
        else if(score >= 10) {
            Toast.makeText(SummaryActivity.this, "Deine Note ist : 2", Toast.LENGTH_LONG).show();
        }
        else if(score >= 8) {
            Toast.makeText(SummaryActivity.this, "Deine Note ist : 3", Toast.LENGTH_LONG).show();
        }
        else if(score >= 6){
            Toast.makeText(SummaryActivity.this, "Deine Note ist : 4", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(SummaryActivity.this, "Deine Note ist : 5", Toast.LENGTH_LONG).show();
        }
    }
}
