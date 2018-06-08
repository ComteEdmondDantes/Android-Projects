package com.hdu.journal;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class MessageActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    private BottomNavigationBar bottomNavigationBar;
//    private BottomNavigationItem msgItem;
//    private BottomNavigationItem taskItem;
//    private BottomNavigationItem noticeItem;
    int lastSelectedPosition = 0;
    private GroupsFragment mGroupsFragment;
    private RecommendFragment mRecommendFragment;
    private FriendsFragment mFriendsFragment;
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);


        Toolbar toolbar = findViewById(R.id.message_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);


        bottomNavigationBar = findViewById(R.id.bottom_nav);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_person_black_36dp, "好友").setActiveColor(R.color.colorPrimaryDark))
                .addItem(new BottomNavigationItem(R.drawable.ic_people_black_36dp, "群组").setActiveColor(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.ic_star_black_36dp, "热门").setActiveColor(R.color.colorPrimary))
                .setFirstSelectedPosition(lastSelectedPosition)
                .initialise();

        bottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mFriendsFragment = FriendsFragment.newInstance("");
        transaction.replace(R.id.tb, mFriendsFragment);
        transaction.commit();
    }


    @Override
    public void onTabSelected(int position) {
        Log.d(TAG, "onTabSelected() called with: " + "position = [" + position + "]");
        FragmentManager fm = this.getFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
//                if (mFriendsFragment == null) {
//                    mFriendsFragment = FriendsFragment.newInstance("");
//                }
                transaction.replace(R.id.tb, mFriendsFragment);
                break;
            case 1:
                if (mGroupsFragment == null) {
                    mGroupsFragment = GroupsFragment.newInstance("");
                }

                transaction.replace(R.id.tb, mGroupsFragment);
                break;
            case 2:
                if (mRecommendFragment == null) {
                    mRecommendFragment = RecommendFragment.newInstance("");
                }
                transaction.replace(R.id.tb, mRecommendFragment);
                break;
            default:
                break;
        }
        transaction.commit();// 事务提交
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

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
