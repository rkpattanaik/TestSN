package com.rkpattanaik.testspotsoon.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rkpattanaik.testspotsoon.R;
import com.rkpattanaik.testspotsoon.adapter.TracksAdapter;
import com.rkpattanaik.testspotsoon.data.repository.VideoTracksRepository;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * @author Rajesh Pattanaik
 */

public class VideosFragment extends Fragment {

    @BindView(R.id.rvTracks)
    RecyclerView rvTracks;
    Unbinder unbinder;
    private TracksAdapter mTracksAdapter = new TracksAdapter();
    private VideoTracksRepository mVideoTracksRepository;

    public static Fragment newInstance() {
        return new VideosFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mVideoTracksRepository = new VideoTracksRepository(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_videos, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initRecyclerView() {
        rvTracks.setLayoutManager(new LinearLayoutManager(getActivity()));
        mTracksAdapter.setTrackList(mVideoTracksRepository.getTracks());
        rvTracks.setAdapter(mTracksAdapter);
    }

}
