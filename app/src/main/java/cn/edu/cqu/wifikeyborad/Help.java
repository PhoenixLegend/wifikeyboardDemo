package cn.edu.cqu.wifikeyborad;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈敬谊 on 2017/3/28.
 */

public class Help extends Activity  {
    private View view1, view2;
    private ViewPager viewPager;//对应的viewPager
    private List<String> titleList;//标题列表数组//   
    private List<View> viewList;//view数组  
    private Toolbar toolbar;
    private PagerTitleStrip mpagertitle;

    Button button = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Utils.onActivityCreateSetTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);



        View.OnClickListener btnListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent returnIntent;
                switch (v.getId())
                {
                    case R.id.button1:
                        System.out.println("主题1");
                        view1.setBackgroundColor(getResources().getColor(R.color.one));
                        view2.setBackgroundColor(getResources().getColor(R.color.one));
                        returnIntent = new Intent();
                        returnIntent.putExtra("result","1");
                        setResult(Activity.RESULT_OK,returnIntent);
                        finish();
                        break;
                    case R.id.button2:
                        System.out.println("主题2");
                        view1.setBackgroundColor(getResources().getColor(R.color.twe));
                        view2.setBackgroundColor(getResources().getColor(R.color.twe));
                        returnIntent = new Intent();
                        returnIntent.putExtra("result","2");
                        setResult(Activity.RESULT_OK,returnIntent);
                        finish();
                        break;
                    case R.id.button3:
                        System.out.println("主题3");
                        view1.setBackgroundColor(getResources().getColor(R.color.there));
                        view2.setBackgroundColor(getResources().getColor(R.color.there));
                        returnIntent = new Intent();
                        returnIntent.putExtra("result","3");
                        setResult(Activity.RESULT_OK,returnIntent);
                        finish();
                        break;
                }
            }
        };


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        LayoutInflater inflater=getLayoutInflater();
        view1 = inflater.inflate(R.layout.helplayout,null);
        view2 = inflater.inflate(R.layout.settinglayout,null);

        view2.findViewById(R.id.button1).setOnClickListener(btnListener);
        view2.findViewById(R.id.button2).setOnClickListener(btnListener);
        view2.findViewById(R.id.button3).setOnClickListener(btnListener);


        viewList = new ArrayList<View>();// 将要分页显示的View装入数组中  
        viewList.add(view1);
        viewList.add(view2);

        titleList = new ArrayList<String>();// 每个页面的Title数据  
        titleList.add("Help");
        titleList.add("Settings");
        mpagertitle = (PagerTitleStrip) findViewById(R.id.pagertitle);
        mpagertitle.setTextSize(TypedValue.COMPLEX_UNIT_PX,80);
        mpagertitle.setTextColor(Color.rgb(255, 255, 255));

        PagerAdapter pagerAdapter = new PagerAdapter() {
            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub  
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub  
                return viewList.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                // TODO Auto-generated method stub  
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub  
                container.addView(viewList.get(position));
                return viewList.get(position);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                // TODO Auto-generated method stub  
                return titleList.get(position);
            }

        };

        Bundle bundle=getIntent().getExtras();
        int currentpage=bundle.getInt("currentpage");

        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(currentpage);
    }
}
