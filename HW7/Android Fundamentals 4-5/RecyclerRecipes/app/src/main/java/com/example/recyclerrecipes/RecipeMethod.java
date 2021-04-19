package com.example.recyclerrecipes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.util.LinkedList;

public class RecipeMethod extends AppCompatActivity {
    private static final String TAG = "RecipeMethod";
    private final LinkedList<String> nRecipeDesc = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_method);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String item_name = null;
        if (extras != null) {
            item_name = extras.getString(ListAdapter.EXTRA_NAME);
        }
        TextView heading = findViewById(R.id.food_name);
        ImageView imageView = findViewById(R.id.food_image);
        TextView description = findViewById(R.id.recipe_description);
        readFile(getResources().openRawResource(R.raw.descriptions), nRecipeDesc);
        heading.setText(item_name);
        if (item_name != null) {
            switch (item_name){
                case "Atolillo":
                    imageView.setImageResource(R.drawable.atolillo);
                    description.setText((CharSequence) nRecipeDesc.get(0));
                    break;
                case "Pio Quinto":
                    imageView.setImageResource(R.drawable.pio_quinto);
                    description.setText((CharSequence) nRecipeDesc.get(1));
                    break;
                case "Rosquillas":
                    imageView.setImageResource(R.drawable.rosquillas);
                    description.setText((CharSequence) nRecipeDesc.get(2));
                    break;
                case "Tres Leches":
                    imageView.setImageResource(R.drawable.tres_leches);
                    description.setText((CharSequence) nRecipeDesc.get(3));
                    break;
                case "Thai Milk Tea":
                    imageView.setImageResource(R.drawable.thai_milk_tea);
                    description.setText((CharSequence) nRecipeDesc.get(4));
                    break;
                case "Matcha Pudding":
                    imageView.setImageResource(R.drawable.matcha_pudding);
                    description.setText((CharSequence) nRecipeDesc.get(5));
                    break;
                case "Bubble Tea":
                    imageView.setImageResource(R.drawable.bubble_tea);
                    description.setText((CharSequence) nRecipeDesc.get(6));
                    break;
                case "Chocolate Mint Bars":
                    imageView.setImageResource(R.drawable.chocolate_mint_bars);
                    description.setText((CharSequence) nRecipeDesc.get(7));
                    break;
                case "Lemon Cake":
                    imageView.setImageResource(R.drawable.lemon_cake);
                    description.setText((CharSequence) nRecipeDesc.get(8));
                    break;
                case "Blueberry Cupcakes":
                    imageView.setImageResource(R.drawable.blueberry_cupcakes);
                    description.setText((CharSequence) nRecipeDesc.get(9));
                    break;
                case "Carrot Cake":
                    imageView.setImageResource(R.drawable.carrot_cake);
                    description.setText((CharSequence) nRecipeDesc.get(10));
                    break;
                case "Blueberry Ice Cream":
                    imageView.setImageResource(R.drawable.blueberry_ice_cream);
                    description.setText((CharSequence) nRecipeDesc.get(11));
                    break;
                default: break;
            }
        }
    }

    private void readFile(InputStream ins, LinkedList<String> list) {
        String contents = null;
        String [] contents_array = null;
        int i;
        try{
            contents = IOUtils.toString(ins);
            System.out.println(contents);
            IOUtils.closeQuietly(ins);
        }
        catch (Exception e){
            Log.e(TAG, Log.getStackTraceString(e));
        }

        if (contents != null) {
            contents_array = contents.split("\\r?\\n");
        }
        if (contents_array != null) {
            for (i = 0; i < contents_array.length ; i++){
                list.add(i, contents_array[i]);
                Log.d("ARRAY CONTENTS", contents_array[i]);

            }
        }
    }
}
