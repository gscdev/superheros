package com.gsc.superheros.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Superhero implements Parcelable {

    private String name;
    private String photo;
    private String realName;
    private String height;
    private String power;
    private String abilities;
    private String groups;

    public Superhero(String name, String photo, String realName, String height, String power, String abilities, String groups) {
        this.name = name;
        this.photo = photo;
        this.realName = realName;
        this.height = height;
        this.power = power;
        this.abilities = abilities;
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    public String getRealName() {
        return realName;
    }

    public String getHeight() {
        return height;
    }

    public String getPower() {
        return power;
    }

    public String getAbilities() {
        return abilities;
    }

    public String getGroups() {
        return groups;
    }

    //region Parcelable
    protected Superhero(Parcel in) {
        name = in.readString();
        photo = in.readString();
        realName = in.readString();
        height = in.readString();
        power = in.readString();
        abilities = in.readString();
        groups = in.readString();
    }

    public static final Creator<Superhero> CREATOR = new Creator<Superhero>() {
        @Override
        public Superhero createFromParcel(Parcel in) {
            return new Superhero(in);
        }

        @Override
        public Superhero[] newArray(int size) {
            return new Superhero[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(photo);
        dest.writeString(realName);
        dest.writeString(height);
        dest.writeString(power);
        dest.writeString(abilities);
        dest.writeString(groups);
    }
    //endregion
}
