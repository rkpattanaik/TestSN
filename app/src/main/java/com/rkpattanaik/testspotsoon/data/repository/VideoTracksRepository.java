package com.rkpattanaik.testspotsoon.data.repository;

import android.content.Context;

import com.rkpattanaik.testspotsoon.R;
import com.rkpattanaik.testspotsoon.data.model.Track;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rajesh Pattanaik
 */

public class VideoTracksRepository {
    private Context context;
    private List<Track> tracks;

    public VideoTracksRepository(Context context) {
        this.context = context;
        initTracksList();
    }

    private void initTracksList() {
        tracks = new ArrayList<>();

        Track track1 = Track.builder()
                .title("Shape of You Ft. Ed Sheeran")
                .timeElapsed(2)
                .description(context.getString(R.string.dummy_track_text))
                .trackCover(R.drawable.cover_shape_of_you)
                .build();
        tracks.add(track1);

        Track track2 = Track.builder()
                .title("Baby Ft. Justin Bieber")
                .timeElapsed(3)
                .description(context.getString(R.string.dummy_track_text))
                .trackCover(R.drawable.cover_baby)
                .build();
        tracks.add(track2);

        Track track3 = Track.builder()
                .title("Let me love you")
                .timeElapsed(7)
                .description(context.getString(R.string.dummy_track_text))
                .trackCover(R.drawable.cover_let_me_love_you)
                .build();
        tracks.add(track3);

        Track track4 = Track.builder()
                .title("Cold Water Ft. Justin Bieber")
                .timeElapsed(9)
                .description(context.getString(R.string.dummy_track_text))
                .trackCover(R.drawable.cover_cold_water)
                .build();
        tracks.add(track4);

        Track track5 = Track.builder()
                .title("Closer Ft. Halsey")
                .timeElapsed(12)
                .description(context.getString(R.string.dummy_track_text))
                .trackCover(R.drawable.cover_closer)
                .build();
        tracks.add(track5);

        Track track6 = Track.builder()
                .title("Never say never")
                .timeElapsed(18)
                .description(context.getString(R.string.dummy_track_text))
                .trackCover(R.drawable.cover_never_say_never)
                .build();
        tracks.add(track6);
    }

    public List<Track> getTracks() {
        return tracks;
    }
}
