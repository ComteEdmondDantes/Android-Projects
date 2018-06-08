package com.hdu.journal;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.setting_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);

        NavigationView navView = findViewById(R.id.nav_setting);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.setting_1:
                        Toast.makeText(getApplicationContext(), "账号管理", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.setting_2:
                        Toast.makeText(getApplicationContext(), "手机绑定", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.setting_3:
                        Toast.makeText(getApplicationContext(), "邮箱绑定", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.setting_4:
                        Toast.makeText(getApplicationContext(), "账号与设备安全", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.setting_5:
                        Toast.makeText(getApplicationContext(), "隐私设置", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.setting_6:
                        Toast.makeText(getApplicationContext(), "查看帮助", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == android.R.id.home)
        {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
