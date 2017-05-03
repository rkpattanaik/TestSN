package com.rkpattanaik.testspotsoon.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rkpattanaik.testspotsoon.R;
import com.rkpattanaik.testspotsoon.data.model.Track;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author Rajesh Pattanaik
 */

public class TracksAdapter extends RecyclerView.Adapter<TracksAdapter.ViewHolder> {
    private List<Track> mTrackList;

    public TracksAdapter() {
        mTrackList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_track, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Track track = mTrackList.get(position);

        holder.ivTrackCover.setImageResource(track.trackCover());
        holder.tvTrackTitle.setText(track.title());
        holder.tvTimeElapsed.setText(String.format("%d hours ago", track.timeElapsed()));
        holder.tvTrackDescription.setText(track.description());
    }

    @Override
    public int getItemCount() {
        return mTrackList != null ? mTrackList.size() : 0;
    }

    public void setTrackList(List<Track> trackList) {
        mTrackList = trackList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivTrackCover)
        ImageView ivTrackCover;
        @BindView(R.id.tvTrackTitle)
        TextView tvTrackTitle;
        @BindView(R.id.tvTimeElapsed)
        TextView tvTimeElapsed;
        @BindView(R.id.tvTrackDescription)
        TextView tvTrackDescription;
        @BindView(R.id.cardTrack)
        CardView cardTrack;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
