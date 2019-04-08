package com.example.firstapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //BACK 버튼을 눌렀을 때,
        Button backBtn = (Button)findViewById(R.id.btn_back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyActivity.this,
                        "돌아가기 버튼이 눌렸어요.", Toast.LENGTH_LONG).show();
                finish(); //Toast 메세지를 띄운 후, MyActivity 화면을 끝낸다.
            }
        });
    }
}
