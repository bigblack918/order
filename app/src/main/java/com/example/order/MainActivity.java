package com.example.order;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    Logger logger = LoggerFactory.getLogger(MainActivity.class);
    private int num = 0;
    private MyOnClickListener myOnClickListener = new MyOnClickListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setOnClickListener(myOnClickListener);
    }

    public void add(View view) {
        num = num + 1;
        display(num);
        logger.debug("ADD");
    }

    public void sub(View view) {
        if (num > 0) num = num - 1;
        display(num);
    }

    public void display(int number) {
        TextView num = (TextView) findViewById(R.id.num);
        num.setText("" + number);
    }

    public void order(View view) {
        EditText name = (EditText) findViewById(R.id.name);
        TextView info = (TextView) findViewById(R.id.info);
        CheckBox addbag = (CheckBox) findViewById(R.id.addbag);
        boolean isAddBag = addbag.isChecked();
        int total = num * 5;
        if (isAddBag) total = total + 2;
        Log.d(TAG, "=====total=====" + total);
        String priceMessage = "顧客名稱: " + name.getText().toString();
        priceMessage += "\n加購塑膠袋? " + (isAddBag ? "有" : "無");
        priceMessage += "\n雞蛋數量： " + num;
        priceMessage += "\n總金額： " + total;
        priceMessage += "\n謝謝惠顧";
        info.setText(priceMessage);
        hideKeyboard();
//        InputMethodManager imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(findViewById(R.id.order).getWindowToken(), 0);
    }


    private void hideKeyboard() {
        InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(getCurrentFocus().getApplicationWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    class MyOnClickListener implements View.OnClickListener {
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.textView:
                    Toast.makeText(view.getContext(), "跟你說了一顆五塊", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

}
