package com.mywindows.alramapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button btnNew;
    private RecyclerView recyclerView;

    private RecyclerViewAdapter adapter;

    private static ArrayList<Alarm> allAlrams;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new RecyclerViewAdapter();

        if (null == allAlrams) {
            allAlrams = new ArrayList<>();
        }

        btnNew = findViewById(R.id.btnNew);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setAlarms(allAlrams);

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddNewAlarmActivity.class);
                startActivity(intent);
            }
        });

        try {
            Intent intent = getIntent();
            Bundle bundle = intent.getBundleExtra(getString(R.string.bundle));
            if  (null != bundle) {
                int hours = bundle.getInt(getString(R.string.hours), -1);
                int minutes = bundle.getInt(getString(R.string.minutes), -1);

                if (hours != -1) {
                    if (minutes != -1) {
                        Intent alramIntent = new Intent(AlarmClock.ACTION_SET_ALARM);
                        alramIntent.putExtra(AlarmClock.EXTRA_HOUR, hours);
                        alramIntent.putExtra(AlarmClock.EXTRA_MINUTES, minutes);
                        alramIntent.putExtra(AlarmClock.EXTRA_MESSAGE, "Wakey! wakey!");

                        Alarm alarm = new Alarm(hours, minutes, "Wakey! wakey!");
                        allAlrams.add(alarm);
                        adapter.setAlarms(allAlrams);
                        startActivity(alramIntent);
                    }
                }
            }else {
                Log.d(TAG, "onCreate: some problem");
            }
            
        }catch (Exception e) {
            Log.d(TAG, "onCreate: Something Happened ");
            e.printStackTrace();
        }


    }
}
