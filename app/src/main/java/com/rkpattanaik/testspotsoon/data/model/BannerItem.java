package com.rkpattanaik.testspotsoon.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Rajesh Pattanaik
 */

public class BannerItem implements Parcelable {

    private int poster;
    private String heading;
    private String subheading;

    public BannerItem(int poster, String heading, String subheading) {
        this.poster = poster;
        this.heading = heading;
        this.subheading = subheading;
    }

    protected BannerItem(Parcel in) {
        poster = in.readInt();
        heading = in.readString();
        subheading = in.readString();
    }

    public static final Creator<BannerItem> CREATOR = new Creator<BannerItem>() {
        @Override
        public BannerItem createFromParcel(Parcel in) {
            return new BannerItem(in);
        }

        @Override
        public BannerItem[] newArray(int size) {
            return new BannerItem[size];
        }
    };

    public int getPoster() {
        return poster;
    }

    public String getHeading() {
        return heading;
    }

    public String getSubheading() {
        return subheading;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(poster);
        parcel.writeString(heading);
        parcel.writeString(subheading);
    }
}
