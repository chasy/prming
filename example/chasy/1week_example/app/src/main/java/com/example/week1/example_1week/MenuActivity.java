package com.example.week1.example_1week;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 차승용 on 2016-05-20.
 */
public class MenuActivity extends Activity{
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);

        TextView MyText = new TextView(this);
        MyText.setText("메뉴를 고르시오\n책 내용 이상함 당연히 안됨 376p");
        setContentView(MyText);
    }

    public boolean onCreateOptionMenu(Menu menu){
        super.onCreateOptionsMenu(menu);

        MenuItem item = menu.add(0,1,0,"짜장");
        item.setIcon(R.drawable.eximg);
        item.setAlphabeticShortcut('a');

        SubMenu etc = menu.addSubMenu("기타");
        etc.add(0, 2, 0, "우동");
        etc.add(0, 3, 0, "만두");

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case 1:
                Toast.makeText(this,"짜장이요",Toast.LENGTH_LONG).show();
                return true;
            case 2:
                Toast.makeText(this,"우동이요",Toast.LENGTH_LONG).show();
                return true;
            case 3:
                Toast.makeText(this,"만두요",Toast.LENGTH_LONG).show();
                return true;
        }
        return false;
    }
}
