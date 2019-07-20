package com.junhwa.sampleparcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable {
    int number;
    String message;

    public SimpleData(int number, String message) {
        this.number = number;
        this.message = message;
    }

    public SimpleData(Parcel src) {
        this.number = src.readInt();
        this.message = src.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        public SimpleData createFromParcel(Parcel parcel) {
            return new SimpleData(parcel);
        }

        @Override
        public SimpleData[] newArray(int i) {
            return new SimpleData[i];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.number);
        parcel.writeString(this.message);
    }
}
