package com.example.order;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    private int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add(View view) {
        num = num + 1;
        display(num);
    }

    public void sub(View view) {
        if (num > 0) num = num - 1;
        display(num);
    }

    public void display(int number) {
        TextView num = (TextView) findViewById(R.id.num);
        Log.d(TAG,"xxxxxxxxxxxx" + number);
        num.setText(""+number);
    }

    public void order(View view) {
        TextView priceNum = (TextView) findViewById(R.id.priceNum);
        Log.d(TAG,"xxxxxxxxxxxx" + num);
        priceNum.setText("$"+num*5);
    }
}
