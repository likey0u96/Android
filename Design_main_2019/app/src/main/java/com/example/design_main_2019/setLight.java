package com.example.design_main_2019;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.util.Log;

import org.w3c.dom.Text;
public class setLight extends AppCompatActivity {



    //자동 밝기 스위치
    Switch swtBri;
    //자동 소등 스위치
    Switch swtBl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_light);
        //typecasting
        swtBri = (Switch)findViewById(R.id.swch_autibrt);
        swtBl = (Switch)findViewById(R.id.swch_autobl);

        //main에서 현재상태를 가져옴
        Intent intent = getIntent();

        String sBri = intent.getStringExtra("IsBright");
        swtBri.setChecked(Boolean.valueOf(sBri));

        String sBl = intent.getStringExtra("IsBlack");
        swtBl.setChecked(Boolean.valueOf(sBl));


        //main 버튼을 눌렀을 때,
        Button backMain = (Button)findViewById(R.id.btn_main);
        backMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(this.getClass().getName(),"Main Button Clicked!!!");
                //main 창으로 넘어가기
                //intent와 bundle을 사용하여 값을 저장하여 보내기
                Intent intent = new Intent(setLight.this, MainActivity.class);

                //boolean 값을 intent에 넣음
                intent.putExtra("IsBright",swtBri.isChecked());
                intent.putExtra("IsBlack",swtBl.isChecked());

                startActivity(intent);
            }
        });






    }


}
