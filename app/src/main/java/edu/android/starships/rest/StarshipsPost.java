package edu.android.starships.rest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StarshipsPost {
    @SerializedName("results")
    private List<StarshipPost> starships;

    public List<StarshipPost> getStarships() {
        return starships;
    }
}
