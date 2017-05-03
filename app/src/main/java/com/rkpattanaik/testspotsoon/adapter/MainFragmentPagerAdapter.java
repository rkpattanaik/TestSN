package com.rkpattanaik.testspotsoon.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rkpattanaik.testspotsoon.R;
import com.rkpattanaik.testspotsoon.fragment.ImagesFragment;
import com.rkpattanaik.testspotsoon.fragment.MilestoneFragment;
import com.rkpattanaik.testspotsoon.fragment.VideosFragment;


/**
 * @author Rajesh Pattanaik
 */

public class MainFragmentPagerAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[] { "Videos", "Images", "Milestone" };
    private int[] icons = {
            R.drawable.tab_video,
            R.drawable.tab_image,
            R.drawable.tab_milestone
    };
    private Context context;

    public MainFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = VideosFragment.newInstance();
                break;
            case 1:
                fragment = ImagesFragment.newInstance();
                break;
            case 2:
                fragment = MilestoneFragment.newInstance();
                break;
            default:
                fragment = VideosFragment.newInstance();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    /**
     * Method to create custom tab bar items
     * @param position Position of the tab bar item in TabLayout
     * @return View
     */
    public View getTabView(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.ivTabIcon);
        TextView textView = (TextView) view.findViewById(R.id.tvTabText);
        imageView.setImageResource(icons[position]);
        textView.setText(tabTitles[position]);
        return view;
    }
}
