package com.example.simpleadapterandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    // initialize View's
    ListView simpleListView;

    // Define fruits name array
    String[] fruitsNames = {
            "Apple",
            "Banana",
            "Litchi",
            "Mango",
            "PineApple"
    };

    // Take all image about fruits in drawable
    int [] fruitsImage = {
            R.drawable.apple,
            R.drawable.banana,
            R.drawable.litchi,
            R.drawable.mango,
            R.drawable.pineapple
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create and check a HashMap
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

        for (int i = 0; i < fruitsNames.length; i++) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("name", fruitsNames[i]);
            hashMap.put("fruit", fruitsImage[i] + "");
            arrayList.add(hashMap);
        }

        String[] from = {"name", "image"};  // String array
        int[] to = {R.id.textView, R.id.imageView};
        SimpleAdapter simpleAdapter = new SimpleAdapter(
                this,
                arrayList,
                R.layout.list_view_items,
                from,
                to
        );
        simpleListView.setAdapter(simpleAdapter);

        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(
                        getApplicationContext(),
                        fruitsNames[i],
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }
}