package com.rkpattanaik.testspotsoon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rkpattanaik.testspotsoon.R;


/**
 * @author Rajesh Pattanaik
 */

public class MilestoneFragment extends Fragment {

    public static Fragment newInstance() {
        return new MilestoneFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_milestone, container, false);
    }
}
