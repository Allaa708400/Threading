package com.example.threading;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button btn_click;
TextView tv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_click = findViewById(R.id.btn_click);
        tv = findViewById(R.id.tv_res);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

     Thread t1 = new Thread(new Runnable() {
         @Override
         public void run() {

             for (int i = 0; i < 5; i++) {

                 try {
                     Thread.sleep(5000);
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 }
                 final int finalI = i;
                 runOnUiThread(new Runnable() {
                     @Override
                     public void run() {

                         tv.setText(finalI+"");
                     }
                 });


             }
         }
     });
     t1.start();

            }
        });
    }
}