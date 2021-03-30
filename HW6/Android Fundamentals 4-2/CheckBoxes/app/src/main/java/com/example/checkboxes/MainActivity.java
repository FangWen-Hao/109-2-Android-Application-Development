package com.example.checkboxes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.widget.Button;
import android.widget.CheckBox;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private final int[] toppings = {R.id.syrup, R.id.sprinkles, R.id.deeznuts, R.id.cherries, R.id.orio};
    private Button chkBox;
    private String Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void ShowToppings(View view) {
        Message = "Toppings:";
        for (int i=0; i < 5; i++){
            chkBox = findViewById(toppings[i]);
            boolean checked = ((CheckBox) (chkBox)).isChecked();
            switch (chkBox.getId()) {
                case R.id.syrup:
                    if (checked){
                        Message += " ";
                        Message += getString(R.string.syrup_text);}
                    break;
                case R.id.sprinkles:
                    if (checked){
                        Message += " ";
                        Message += getString(R.string.sprinkles_text);}
                    break;
                case R.id.deeznuts:
                    if (checked) {
                        Message += " ";
                        Message += getString(R.string.deeznuts_text);}
                    break;
                case R.id.cherries:
                    if (checked) {
                        Message += " ";
                        Message += getString(R.string.cherries_text);}
                    break;
                case R.id.orio:
                    if (checked) {
                        Message += " ";
                        Message += getString(R.string.orio_text);}
                    break;
                default:
                    // Do nothing.
                    break;
            }
        }
        displayToast(Message);
    }
}