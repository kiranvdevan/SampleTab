package com.kiranpv.sampletab.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kiranpv.sampletab.R;
import com.kiranpv.sampletab.custom.CustomViewPager;
import com.kiranpv.sampletab.fragment.AboutFragment;
import com.kiranpv.sampletab.fragment.MyArtsFragment;
import com.kiranpv.sampletab.fragment.MyCollectionsFragment;
import com.kiranpv.sampletab.fragment.MyWallFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private CustomViewPager customViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        customViewPager = (CustomViewPager) findViewById(R.id.viewpager);
        setupViewPager(customViewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(customViewPager);
        setupTabIcons();
    }

    /**
     * Adding fragments to ViewPager
     * @param customViewPager
     */
    private void setupViewPager(CustomViewPager customViewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new MyWallFragment(), "My Wall");
        adapter.addFrag(new MyArtsFragment(), "My Art");
        adapter.addFrag(new MyCollectionsFragment(), "My Collections");
        adapter.addFrag(new AboutFragment(), "About");
        customViewPager.setAdapter(adapter);
        customViewPager.setPagingEnabled(false);
    }

    private void setupTabIcons() {

        //RelativeLayout tabOneLayout = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("My Walls");
        tabOne.setTextColor(Color.parseColor("#FFFFFF"));
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, android.R.drawable.ic_lock_silent_mode, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("My Art");
        tabTwo.setTextColor(Color.parseColor("#FFFFFF"));
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, android.R.drawable.ic_dialog_dialer, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("My Collections");
        tabThree.setTextColor(Color.parseColor("#FFFFFF"));
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, android.R.drawable.ic_lock_silent_mode, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);

        TextView tabFour = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabFour.setText("About");
        tabFour.setTextColor(Color.parseColor("#FFFFFF"));
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, android.R.drawable.ic_dialog_dialer, 0, 0);
        tabLayout.getTabAt(3).setCustomView(tabFour);
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

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
