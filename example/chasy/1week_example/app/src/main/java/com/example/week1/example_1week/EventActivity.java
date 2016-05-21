package com.example.week1.example_1week;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by 차승용 on 2016-05-20.
 */
public class EventActivity extends Activity {
    private MyView vw;

    public class Vertex {
        Vertex(float ax, float ay, boolean ad) {
            x = ax;
            y = ay;
            draw = ad;
        }

        float x;
        float y;
        boolean draw;
    }

    ArrayList<Vertex> arVertex;

    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        vw = new MyView(this);
        setContentView(vw);

        arVertex = new ArrayList<Vertex>();
    }

    protected class MyView extends View {
        Paint mPaint;

        public MyView(Context context) {
            super(context);

            mPaint =new Paint();
            mPaint.setColor(Color.BLACK);
            mPaint.setStrokeWidth(3);
            mPaint.setAntiAlias(true);
        }

        public void onDraw(Canvas canvas){
            canvas.drawColor(Color.LTGRAY);

            for(int i=0; i<arVertex.size();i++){
                if(arVertex.get(i).draw){
                    canvas.drawLine(arVertex.get(i-1).x, arVertex.get(i-1).y,
                            arVertex.get(i).x, arVertex.get(i).y, mPaint);
                }
            }
        }

        public boolean onTouchEvent(MotionEvent event){
            if(event.getAction()==MotionEvent.ACTION_DOWN){
                arVertex.add(new Vertex(event.getX(), event.getY(), false));
                return true;
            }
            if(event.getAction() == MotionEvent.ACTION_MOVE){
                arVertex.add(new Vertex(event.getX(), event.getY(), true));
                invalidate();
                return true;
            }
            return false;
        }
    }


//    public void onCreate(Bundle saveInstanceState){
//        super.onCreate(saveInstanceState);
//        View vw = new View(this);
//        vw.setOnTouchListener(TouchListener);
//        setContentView(vw);
//    }
//
//    View.OnTouchListener TouchListener = new View.OnTouchListener(){
//      public boolean onTouch(View v, MotionEvent event){
//          if(event.getAction() == MotionEvent.ACTION_DOWN){
//              Toast.makeText(EventActivity.this, "터치", Toast.LENGTH_SHORT).show();
//              return true;
//          }
//          return false;
//      }
//    };


//    public void onCreate(Bundle saveInstatnceState) {
//        super.onCreate(saveInstatnceState);
//        //View vw = new MyView(this);
//        View vw = new View(this);
//        vw.setOnTouchListener(TouchListner);
//        setContentView(vw);
//
//    }
//
//    class TouchListenerClass implements View.OnTouchListener {
//        public boolean onTouch(View v, MotionEvent event) {
//            if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                Toast.makeText(EventActivity.this, "터치 이벤트 발생", Toast.LENGTH_SHORT).show();
//                return true;
//            }
//            return false;
//        }
//    }
//
//    TouchListenerClass TouchListner = new TouchListenerClass();
//
//    class MyView extends View {
//        public MyView(Context context) {
//            super(context);
//        }
//
//        public boolean onTouchEvent(MotionEvent event) {
//            super.onTouchEvent(event);
//
//            if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                Toast.makeText(EventActivity.this, "터치 이벤트 발생", Toast.LENGTH_SHORT).show();
//                return true;
//            }
//
//            return false;
//        }
//
//    }
}
