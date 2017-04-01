package cn.edu.cqu.wifikeyborad;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.design.widget.NavigationView;

import static cn.edu.cqu.wifikeyborad.R.id.drawerlayout;
import static cn.edu.cqu.wifikeyborad.R.id.help;
import static cn.edu.cqu.wifikeyborad.R.id.navigationView;
import static cn.edu.cqu.wifikeyborad.R.styleable.MenuItem;
import static cn.edu.cqu.wifikeyborad.R.styleable.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView lvLeftMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar =(Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Now you see me");//设置Toolbar标题
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));//设置标题颜色
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);//设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //创建返回键，并实现打开关/闭监听
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close) {
        @Override
        public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                }
         @Override
         public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
             }
          };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView) ;
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }}

        android.view.MenuItem item;
        public boolean onNavigationItemSelected(MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();
            switch (id) {
                case R.id.invite:
                    mDrawerLayout.closeDrawers();
                    Uri uri = Uri.parse("https://phoenixlegend.github.io/");
                    Intent invite = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(invite);
                    break;

                case R.id.help:
                    mDrawerLayout.closeDrawers();
                    Intent intentHelp = new Intent();
                    intentHelp.setClass(this.getApplicationContext(),Help.class);
                    intentHelp.putExtra("currentpage",0);
                    startActivity(intentHelp);
                    break;
                case R.id.settings:
                    mDrawerLayout.closeDrawers();
                    Intent intentSettings = new Intent();
                    intentSettings.setClass(this.getApplicationContext(),Help.class);
                    intentSettings.putExtra("currentpage",1);
                    startActivityForResult(intentSettings, 1);
                   break;
                case R.id.quit:
                    finishAffinity();
                    break;
                default:

                    break;
            }

            return true;
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                switch (result){
                    case "1":
                        mDrawerLayout.setBackgroundColor(getResources().getColor(R.color.one));
                        break;
                    case "2":
                        mDrawerLayout.setBackgroundColor(getResources().getColor(R.color.twe));
                        break;
                    case "3":
                        mDrawerLayout.setBackgroundColor(getResources().getColor(R.color.there));
                        break;

                }
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }

    public void inputmethod(View view) {
        //        Intent intent=new Intent(android.provider.Settings.ACTION_INPUT_METHOD_SETTINGS);
//        startActivity(intent);
        InputMethodManager imeManager = (InputMethodManager) getApplicationContext().getSystemService(INPUT_METHOD_SERVICE);
        imeManager.showInputMethodPicker();

    }
}



