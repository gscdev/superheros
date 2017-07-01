package com.gsc.superheros.data.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SuperherosResponse {

    @SerializedName("superheroes")
    public List<SuperheroResponse> superheroes;

    public List<SuperheroResponse> getSuperheroes() {
        return superheroes;
    }

    public class SuperheroResponse {

        @SerializedName("name")
        public String name;
        @SerializedName("photo")
        public String photo;
        @SerializedName("realName")
        public String realName;
        @SerializedName("height")
        public String height;
        @SerializedName("power")
        public String power;
        @SerializedName("abilities")
        public String abilities;
        @SerializedName("groups")
        public String groups;

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
    }
}
