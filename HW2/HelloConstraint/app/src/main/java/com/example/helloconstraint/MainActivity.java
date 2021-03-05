package com.example.helloconstraint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        mButtonZero = (Button) findViewById(R.id.button_zero);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();

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
}