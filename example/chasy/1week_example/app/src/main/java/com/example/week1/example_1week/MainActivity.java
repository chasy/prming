package com.example.week1.example_1week;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int value = 0;
    int value2 = 0;
    TextView mText;
    TextView mText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btnInsert);
        btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                EditText txtMsg = (EditText) findViewById(R.id.txtMsg);
                String msg = txtMsg.getText().toString();
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }

        });


        Button btnFrame = (Button) findViewById(R.id.btnFrameTest);
        btnFrame.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                ImageView img = (ImageView) findViewById(R.id.imgFrameTest);
                if (img.getVisibility() == View.VISIBLE) {
                    img.setVisibility(View.INVISIBLE);
                } else {
                    img.setVisibility(View.VISIBLE);
                }
            }

        });

        findViewById(R.id.btnGoEvent).setOnLongClickListener(mLongClickListener);

        //타이머
        mText2 = (TextView) findViewById(R.id.txtTimer2);
        new CountDownTimer(11 * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                value2++;
                mText2.setText("얜 10초까지만 " + value2);
            }

            public void onFinish() {

            }
        }.start();

        //타이머2
        mText = (TextView) findViewById(R.id.txtTimer);
        mHandler.sendEmptyMessage(0);

    }

    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            value++;
            mText.setText("초당1증가 " + value);
            mHandler.sendEmptyMessageDelayed(0, 1000);
        }
    };

    public void GoCanvas(View v) {
        Intent intent = new Intent(this, CanvasActivity.class);

        startActivity(intent);
    }

    public void GoEvent(View v) {
        Intent intent = new Intent(this, EventActivity.class);
        startActivity(intent);
    }

    View.OnLongClickListener mLongClickListener = new View.OnLongClickListener() {
        public boolean onLongClick(View v) {
            Intent intent = new Intent(MainActivity.this, EventActivity.class);
            startActivity(intent);
            return true;
        }
    };

    public void GoMenu(View v){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
