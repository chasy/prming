package com.example.week1.example_1week;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
    }

    public void GoCanvas(View v) {
        Intent intent = new Intent(this, CanvasActivity.class);

        startActivity(intent);
    }
}
