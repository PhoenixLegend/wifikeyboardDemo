package cn.edu.cqu.themeshiftingdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {
    Button button = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        Utils.onActivityCreateSetTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button0).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);


    }
    @Override
    public void onClick(View v)
    {
        System.out.println("单击按钮");
        // TODO Auto-generated method stub
        switch (v.getId())
        {
            case R.id.button0:
                System.out.println("主题1");
                Utils.changeToTheme(this, 1);
                break;
            case R.id.button1:
                System.out.println("主题2");
                Utils.changeToTheme(this, 2);
                break;
        }

    }
}








