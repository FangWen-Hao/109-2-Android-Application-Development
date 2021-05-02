package com.example.batterydisplay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private int BatteryLvl = 0;
    private ImageView Battery;
    static final String BatteryState = "Battery Level";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Battery = findViewById(R.id.battery);
        if (savedInstanceState != null){
            BatteryLvl = savedInstanceState.getInt(BatteryState);
        }
        Battery.setImageLevel(BatteryLvl);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(BatteryState, BatteryLvl);
        super.onSaveInstanceState(outState);
    }

    public void GoDown(View view) {
        if (BatteryLvl == 0){
            BatteryLvl = 0;
        }
        else {
            BatteryLvl -= 1;
        }
        Battery.setImageLevel(BatteryLvl);
    }

    public void GoUp(View view) {
        if (BatteryLvl == 6){
            BatteryLvl = 6;
        }
        else {
            BatteryLvl += 1;
        }
        Battery.setImageLevel(BatteryLvl);
    }
}