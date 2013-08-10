package com.as.serveraidl;

import android.os.Parcel;
import android.os.Parcelable;

public final class Rectangle implements Parcelable {
	public int left;
	public int top;
	public int right;
	public int bottom;

	public static final Parcelable.Creator<Rectangle> CREATOR = new Parcelable.Creator<Rectangle>() {
		public Rectangle createFromParcel(Parcel in) {
			return new Rectangle(in);
		}

		public Rectangle[] newArray(int size) {
			return new Rectangle[size];
		}
	};

	public Rectangle() {
	}
	
	public Rectangle(int top, int left, int bottom, int right) {
		this.top = top;
		this.left = left;
		this.bottom = bottom;
		this.right = right;
	}

	private Rectangle(Parcel in) {
		readFromParcel(in);
	}

	public void writeToParcel(Parcel out, int arg) {
		out.writeInt(left);
		out.writeInt(top);
		out.writeInt(right);
		out.writeInt(bottom);
	}

	public void readFromParcel(Parcel in) {
		left = in.readInt();
		top = in.readInt();
		right = in.readInt();
		bottom = in.readInt();
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

}
