package com.example.helloconstraint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button mButtonZero;
    public static final String EXTRA_MESSAGE =  "com.example.android.twoactivities.extra.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        mButtonZero = (Button) findViewById(R.id.button_zero);
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
            mButtonZero.setBackgroundColor(getResources().getColor(R.color.ColorfulMustard));
            if (mCount%2 == 0) {
                view.setBackgroundColor(getResources().getColor(R.color.EvenRed));;
            }
            else if (mCount%2 == 1){
                view.setBackgroundColor(getResources().getColor(R.color.OddBlue));
            }

    }

    public void goZero(View view){
        mCount = 0;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
            view.setBackgroundColor(getResources().getColor(R.color.ZeroGray));
    }

    public void hellotoast(View view) {
        Intent intent = new Intent(this, SayHello.class);
        String Number = mShowCount.getText().toString();
        intent.putExtra(EXTRA_MESSAGE , Number);
        startActivity(intent);

    }
}