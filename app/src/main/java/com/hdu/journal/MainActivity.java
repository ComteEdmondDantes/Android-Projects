package com.hdu.journal;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private DrawerLayout mDrawerLayout;
    Button createButton;
    Button openButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);


        FloatingActionButton fab = findViewById(R.id.main_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_create = new Intent(MainActivity.this, CreateActivity.class);
                Toast.makeText(getApplicationContext(), "新建日记", Toast.LENGTH_SHORT).show();
                startActivity(intent_create);
            }
        });

        }

        NavigationView navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_person:
                        Intent intent_person = new Intent(MainActivity.this, PersonActivity.class);
                        Toast.makeText(getApplicationContext(),"打开个人信息", Toast.LENGTH_SHORT).show();
                        startActivity(intent_person);
                        break;
                    case R.id.nav_notice:
                        Intent intent_notice = new Intent(MainActivity.this, NoticeActivity.class);
                        Toast.makeText(getApplicationContext(), "打开通知窗口", Toast.LENGTH_SHORT).show();
                        startActivity(intent_notice);
                        break;
                    case R.id.nav_message:
                        Intent intent_message = new Intent(MainActivity.this, MessageActivity.class);
                        Toast.makeText(getApplicationContext(), "打开消息窗口", Toast.LENGTH_SHORT).show();
                        startActivity(intent_message);
                        break;
                    case R.id.nav_setting:
                        Intent intent_setting = new Intent(MainActivity.this, SettingActivity.class);
                        Toast.makeText(getApplicationContext(), "打开设置", Toast.LENGTH_SHORT).show();
                        startActivity(intent_setting);
                        break;
                }
                mDrawerLayout.closeDrawers();
                return true;
            }
        });


        createButton =  findViewById(R.id.create_button);
        openButton =  findViewById(R.id.open_button);
        openButton.setOnClickListener(this);
        createButton.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.create_button:
                Intent intent_create = new Intent(MainActivity.this, CreateActivity.class);
                Toast.makeText(getApplicationContext(), "新建日记", Toast.LENGTH_SHORT).show();
                startActivity(intent_create);
                break;
            case R.id.open_button:
                Intent intent_open = new Intent(MainActivity.this, OpenActivity.class);
                Toast.makeText(getApplicationContext(), "打开日记", Toast.LENGTH_SHORT).show();
                startActivity(intent_open);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_toolbar, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.main_backup:
                Toast.makeText(getApplicationContext(), "已将数据同步至云端", Toast.LENGTH_SHORT).show();
                break;
            }
            return true;
        }
}
