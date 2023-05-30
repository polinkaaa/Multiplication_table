package com.demo.multiplicationtable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private ListView listViewTable;
    private ArrayList<String> numbers;
    private int max = 20;
    private int min = 1;
    private int count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(max);
        listViewTable = findViewById(R.id.listViewTable);
        numbers = new ArrayList<>();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, numbers);
        listViewTable.setAdapter(arrayAdapter);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                numbers.clear();
                if (progress < min) {
                    progress = min;
                }
                for (int i = min; i <= count; i++) {
                    numbers.add(progress + " * " + i + " = " + (progress * i));
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar.setProgress(10);
    }
}