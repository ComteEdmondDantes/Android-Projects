package com.hdu.journal;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class NoticeActivity extends AppCompatActivity {

    private String[] noticeData = {"人机交互技术期末作业", "该界面用于显示系统通知", "右上角图标用于删除通知", "1", "222", "333", "4444",
            "55555", "666666", "7777777", "88888888", "999999999", "000", "0000000", "123456789", "9876543210"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.notice_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(NoticeActivity.this, android.R.layout.simple_list_item_1, noticeData);
        ListView listView = findViewById(R.id.notice_list);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.notice_toolbar, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()){
        case R.id.notice_clear:
            Toast.makeText(getApplicationContext(), "清空通知", Toast.LENGTH_SHORT).show();
            ListView listView = findViewById(R.id.notice_list);
            listView.setAdapter(null);
            break;
        case android.R.id.home:
            finish();
            break;
        }
    return true;
    }
}
