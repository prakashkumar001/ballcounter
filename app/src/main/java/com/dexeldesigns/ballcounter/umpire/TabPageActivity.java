package com.dexeldesigns.ballcounter.umpire;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

import com.dexeldesigns.ballcounter.MainActivity;
import com.dexeldesigns.ballcounter.R;
import com.dexeldesigns.ballcounter.common.GlobalClass;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Creative IT Works on 25-Jul-17.
 */

public class TabPageActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    GlobalClass global;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabpage);
        global=(GlobalClass)getApplicationContext();
        global.TabActivitycount="1";
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.x = -20;
        params.height = 500;
        params.width = 550;
        params.y = -10;

        this.getWindow().setAttributes(params);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#1A4E8A"));
        tabLayout.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));
        tabLayout.setTabTextColors( Color.parseColor("#ff000000"), Color.parseColor("#1A4E8A"));
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "RUN");
        adapter.addFragment(new SecondFragment(), "WICKET");
        viewPager.setAdapter(adapter);

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        global.TabActivitycount="0";

        Intent i=new Intent(TabPageActivity.this, MainActivity.class);
        startActivity(i);
        ActivityCompat.finishAffinity(TabPageActivity.this);
    }
}
