package edu.android.starships.rest;
import com.google.gson.annotations.SerializedName;

public class StarshipPost {

    @SerializedName("name")
    private String name;

    @SerializedName("model")
    private String model;

    @SerializedName("starship_class")
    private String starship_class;

    @SerializedName("manufacturer")
    private String manufacturer;

    @SerializedName("length")
    private String length;

    @SerializedName("crew")
    private String crew;

    @SerializedName("cost_in_credits")
    private String cost_in_credits;

    public StarshipPost () { }

    public StarshipPost(String name, String model, String starship_class, String manufacturer, String length, String crew, String cost_in_credits) {
        this.name = name;
        this.model = model;
        this.starship_class = starship_class;
        this.manufacturer = manufacturer;
        this.length = length;
        this.crew = crew;
        this.cost_in_credits = cost_in_credits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStarship_class() {
        return starship_class;
    }

    public void setStarship_class(String starship_class) {
        this.starship_class = starship_class;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getCost_in_credits() {
        return cost_in_credits;
    }

    public void setCost_in_credits(String cost_in_credits) {
        this.cost_in_credits = cost_in_credits;
    }
}

