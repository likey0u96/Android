package com.example.design_main_2019;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView stateView;

    //main activity의 자동 밝기 상태 표시 view
    TextView stateBri;

    //자동 소등 상태 표시 view
    TextView stateBl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //현재 상태를 표시하는 View
        stateView = (TextView)findViewById(R.id.state_autobri);
        //setting 버튼을 누름
        Button sett = (Button)findViewById(R.id.btn_set);
        sett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setting 창으로 넘어가기
                Intent intent = new Intent(MainActivity.this, setLight.class);

                //main의 현재상태를 전달
                intent.putExtra("IsBright",stateBri.getText());
                intent.putExtra("IsBlack",stateBl.getText());
                startActivity(intent);
            }
        });

        //onoff 버튼
        Button onoff = (Button)findViewById(R.id.tog_onoff);
        onoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //버튼을 누르면 ..
            }
        });

        //자동밝기 버튼 intent 받아오기
        Intent myIntent = getIntent();//이 액티비티를 받은 인탠트를 받는다.
        Boolean briData = myIntent.getBooleanExtra("IsBright",false);

        //main activity의 자동 밝기 상태 표시 view
        stateBri = (TextView)findViewById(R.id.state_autobri);
        stateBri.setText(String.valueOf(briData));


        //자동밝기 버튼 intent 받아오기
        Intent myIntent2 = getIntent();
        Boolean blData = myIntent2.getBooleanExtra("IsBlack", false);

        //자동 소등 표시 view
        stateBl = (TextView)findViewById(R.id.state_autobl);
        stateBl.setText(String.valueOf(blData));


    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        Log.e(this.getClass().getName(),"Back to Normal");
//        if(resultCode == 101){
//            if(resultCode == RESULT_OK){
//                Bundle bundle = data.getExtras();
//                Log.e(this.getClass().getName(),"11"+bundle.getBoolean("IsBright"));
//                Boolean briSt = bundle.getBoolean("IsBright");
//                Log.e(this.getClass().getName(),"11"+briSt);
//                if(briSt == true) {
//                    stateBri.setText("ON");
//                }
//                else
//                    stateBri.setText("OFF");
//            }
//        }
//    }



}
