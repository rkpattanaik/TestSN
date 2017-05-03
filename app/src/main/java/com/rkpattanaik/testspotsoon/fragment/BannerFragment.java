package com.rkpattanaik.testspotsoon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rkpattanaik.testspotsoon.data.model.BannerItem;
import com.rkpattanaik.testspotsoon.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * @author Rajesh Pattanaik
 */

public class BannerFragment extends Fragment {

    private static final String BUNDLE_EXTRA = "BUNDLE_EXTRA";
    @BindView(R.id.ivPoster)
    ImageView ivPoster;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvFtBy)
    TextView tvFtBy;
    Unbinder unbinder;

    private BannerItem mBannerItem;

    public static BannerFragment newInstance(BannerItem item) {
        Bundle args = new Bundle();
        args.putParcelable(BUNDLE_EXTRA, item);
        BannerFragment fragment = new BannerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mBannerItem = getArguments().getParcelable(BUNDLE_EXTRA);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_banner, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mBannerItem != null) {
            tvTitle.setText(mBannerItem.getHeading());
            tvFtBy.setText(mBannerItem.getSubheading());
            ivPoster.setImageResource(mBannerItem.getPoster());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
