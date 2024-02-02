package com.first.touristguideapi.model;

public class TouristAttraction {

    private String name;
    private String description;

    public TouristAttraction(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Tourist Attraction: " + name + "\nDescription: " + description;
    }
}
