package com.example.firstapplication2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TOAST 버튼을 눌렀을 때,
        Button btn = (Button)findViewById(R.id.btn_toast);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "시작 버튼이 눌렸어요.", Toast.LENGTH_LONG).show();
                                                    //short : 2초 , long : 3.5초
            }
        });

        //GOOLGE 버튼을 눌렀을 때,
        Button btn2 = (Button)findViewById(R.id.btn_google);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.co.kr"));

                startActivity(myIntent); //activity(화면) 을 띄워라
            }
        });

        //TEL 버튼을 눌렀을 때,
        Button btn3 = (Button)findViewById(R.id.btn_tel);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1234-5678"));
                                                //또는 ACTION_DIAL 전화거는 화면을 띄우기
                                                //ACTION_CALL 전화를 걸기
                startActivity(myIntent);
            }
        });


        //START 버튼을 눌렀을 때,
        Button startBtn = (Button)findViewById(R.id.btn_start);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //toast 메세지를 띄운 후,
                Toast.makeText(getApplicationContext(), "시작 버튼이 눌렸어요.", 1000).show();

                //MyActivity 창을 띄운다.
                Intent myIntent = new Intent(MainActivity.this, MyActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
