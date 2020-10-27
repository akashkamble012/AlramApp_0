package com.mywindows.alramapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button btnNew;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNew = findViewById(R.id.btnNew);
        recyclerView = findViewById(R.id.recyclerView);

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddNewAlarmActivity.class );
                startActivity(intent);
            }
        });

        try {
            Intent intent = getIntent();
            Bundle bundle = intent.getBundleExtra(getString(R.string.bundle));
            if  (null != bundle) {
                int hours = bundle.getInt(getString(R.string.hours), -1);
                int minutes = bundle.getInt(getString(R.string.minutes), -1);
                if 
            }else {
                Log.d(TAG, "onCreate: some problem");
            }
            
        }catch (Exception e) {
            Log.d(TAG, "onCreate: Something Happened ");
            e.printStackTrace();
        }


    }
}
