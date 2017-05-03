package com.rkpattanaik.testspotsoon.data.model;

/**
 * @author Rajesh Pattanaik
 */

public class Track {
    private String title, description;
    private int trackCover;
    private int timeElapsed;

    private Track(Builder builder) {
        title = builder.title;
        description = builder.description;
        trackCover = builder.trackCover;
        timeElapsed = builder.timeElapsed;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String title;
        private String description;
        private int trackCover;
        private int timeElapsed;

        private Builder() {
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder trackCover(int val) {
            trackCover = val;
            return this;
        }

        public Builder timeElapsed(int val) {
            timeElapsed = val;
            return this;
        }

        public Track build() {
            return new Track(this);
        }
    }

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    public int trackCover() {
        return trackCover;
    }

    public int timeElapsed() {
        return timeElapsed;
    }
}
