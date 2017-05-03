package com.rkpattanaik.testspotsoon.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rkpattanaik.testspotsoon.data.model.BannerItem;
import com.rkpattanaik.testspotsoon.fragment.BannerFragment;

import java.util.List;


/**
 * @author Rajesh Pattanaik
 */

public class BannerFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context context;
    private List<BannerItem> bannerItems;

    public BannerFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    public void setBannerItems(List<BannerItem> bannerItems) {
        this.bannerItems = bannerItems;
    }

    @Override
    public Fragment getItem(int position) {
        return BannerFragment.newInstance(bannerItems.get(position));
    }

    @Override
    public int getCount() {
        return bannerItems != null ? bannerItems.size() : 0;
    }
}
