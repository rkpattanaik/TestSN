package com.rkpattanaik.testspotsoon;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.rkpattanaik.testspotsoon.adapter.BannerFragmentPagerAdapter;
import com.rkpattanaik.testspotsoon.adapter.MainFragmentPagerAdapter;
import com.rkpattanaik.testspotsoon.data.repository.BannerItemsRepository;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.vpBanner)
    ViewPager vpBanner;
    @BindView(R.id.layoutPageIndicator)
    LinearLayout layoutPageIndicator;

    private Drawer mNavDrawer;
    private Timer mTimer;
    private int count = 0, noOfBanners;
    private ImageView[] mPagerIndicators;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("Home".toUpperCase());

        BannerItemsRepository bannerItemsRepository = new BannerItemsRepository();
        BannerFragmentPagerAdapter bannerAdapter = new BannerFragmentPagerAdapter(getSupportFragmentManager(), this);
        bannerAdapter.setBannerItems(bannerItemsRepository.getBannerItems());
        vpBanner.setAdapter(bannerAdapter);
        vpBanner.setCurrentItem(0);
        vpBanner.addOnPageChangeListener(this);
        noOfBanners = bannerItemsRepository.getBannerItems().size();
        setBannerPagerIndicators();

        MainFragmentPagerAdapter pagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(pagerAdapter.getTabView(i));
            }
        }

        setupNavDrawer();
    }

    /**
     * This method sets up the ViewPagerIndicator for banner
     */
    private void setBannerPagerIndicators() {
        mPagerIndicators = new ImageView[noOfBanners];
        for (int i = 0; i < mPagerIndicators.length; i++) {
            mPagerIndicators[i] = new ImageView(this);
            mPagerIndicators[i].setImageResource(R.drawable.indicator_nonselected);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                                                                    LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            layoutPageIndicator.addView(mPagerIndicators[i], params);
        }
        mPagerIndicators[0].setImageResource(R.drawable.indicator_selected);
    }

    @Override
    protected void onStart() {
        super.onStart();
        startBannerSlideShow();
    }

    /**
     * This method starts the TimerTask to handle slide show of banner
     */
    private void startBannerSlideShow() {
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (count <= noOfBanners) count++;
                        else count = 0;
                        vpBanner.setCurrentItem(count);
                    }
                });
            }
        }, 5000, 5000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mTimer != null) mTimer.cancel();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mNavDrawer.openDrawer();
        }
        return true;
    }

    /**
     * Setting up the Navigation Drawer using MaterialDrawer Library
     */
    private void setupNavDrawer() {
        mNavDrawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withTranslucentStatusBar(false)
                .addDrawerItems(
                        new PrimaryDrawerItem()
                                .withName("Home")
                                .withIdentifier(1)
                                .withIcon(GoogleMaterial.Icon.gmd_home)
                                .withSelectable(true),
                        new PrimaryDrawerItem()
                                .withName("About us")
                                .withIdentifier(2)
                                .withIcon(R.drawable.drawer_about_us)
                                .withSelectable(true),
                        new PrimaryDrawerItem()
                                .withName("Milestone")
                                .withIdentifier(3)
                                .withIcon(R.drawable.drawer_milestone)
                                .withSelectable(true)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        switch ((int) drawerItem.getIdentifier()) {
                            case 1:
                                Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                Toast.makeText(MainActivity.this, "About us", Toast.LENGTH_SHORT).show();
                                break;
                            case 3:
                                Toast.makeText(MainActivity.this, "Milestone", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                })
                .build();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (ImageView pagerIndicator : mPagerIndicators) {
            pagerIndicator.setImageResource(R.drawable.indicator_nonselected);
        }
        mPagerIndicators[position].setImageResource(R.drawable.indicator_selected);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
