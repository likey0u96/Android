package com.example.firstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //todo : 7강
    TextView messageView;
    EditText inputView;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //activity 위치 설정

        // 각각의 타입으로 typecast
        messageView = (TextView)findViewById(R.id.text_message);
        inputView = (EditText)findViewById(R.id.edit_input);
        Button btn = (Button)findViewById(R.id.btn_send);
        //

        // 버튼이 눌리면 clickListener의 OnClick을 실행시켜달라
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //button을 누르면 inputView 에 입력한 텍스트를 messageView에 보여주기
                messageView.setText(inputView.getText().toString());
            }
        });
        //
    }
}
