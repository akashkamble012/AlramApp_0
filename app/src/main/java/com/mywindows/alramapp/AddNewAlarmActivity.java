package com.mywindows.alramapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewAlarmActivity extends AppCompatActivity {
    private static final String TAG = "AddNewAlarmActivity";

    private EditText editTextHours, editTextMins;
    private Button btnAddNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_alarm);

        editTextHours = findViewById(R.id.edtTxtHour);
        editTextHours = findViewById(R.id.edtTxtMin);
        btnAddNew = findViewById(R.id.btnAddNew);

        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddNewAlram();

            }
        });
    }

    private void AddNewAlram() {
        Log.d(TAG, "AddNewAlram: Started");
        int hours = Integer.valueOf(editTextHours.getText().toString());
        int minutes = Integer.valueOf(editTextMins.getText().toString());

        Bundle bundle = new Bundle();
        bundle.putInt(getString(R.string.hours), hours);
        bundle.putInt(getString(R.string.minutes), minutes);

        Intent intent = new Intent(AddNewAlarmActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(getString(R.string.bundle), bundle);
        startActivity(intent);
    }
}