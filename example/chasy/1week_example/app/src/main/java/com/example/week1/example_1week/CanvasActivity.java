package com.example.week1.example_1week;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;

/**
 * Created by 차승용 on 2016-05-19.
 */
public class CanvasActivity extends Activity {
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        MyView mv = new MyView(this);
        setContentView(mv);
        //setContentView(R.layout.activity_canvas);
    }

    class MyView extends View {
        Paint pnt = new Paint();
        int[] colors = {Color.RED, Color.BLUE, Color.GREEN};

        public MyView(Context context) {
            super(context);

        }

        public void onDraw(Canvas canvas) {
            canvas.drawColor(Color.LTGRAY);
            pnt.setColor(Color.BLUE);
            canvas.drawCircle(100, 100, 80, pnt);

            pnt.setColor(Color.RED);
            canvas.drawRect(10, 100, 200, 170, pnt);

            pnt.setColor(Color.BLACK);
            pnt.setTextSize(60);
            canvas.drawOval(new RectF(50, 50, 200, 120), pnt);
            canvas.drawText("TEST", 210, 70, pnt);

            pnt.setShader(new LinearGradient(0,0,320,0,colors,null, Shader.TileMode.CLAMP));
            canvas.drawRect(0,260,320,300,pnt);
        }
    }
}
