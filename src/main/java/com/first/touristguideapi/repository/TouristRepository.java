package com.first.touristguideapi.repository;

import com.first.touristguideapi.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class TouristRepository {

    private final ArrayList<TouristAttraction> attractions;

    public TouristRepository() {
        attractions = new ArrayList<>();
        attractions.add(new TouristAttraction("Tårn", "Højt tårn"));
        attractions.add(new TouristAttraction("Hulk", "Grøn"));
    }

    // ADD
    public void addTouristAttraction(TouristAttraction touristAttraction) {
        attractions.add(touristAttraction);
    }

    // REMOVE
    public void removeTouristAttraction(TouristAttraction touristAttraction) {
        attractions.remove(touristAttraction);
    }

    // SPECIFIC ATTRACTION
    public TouristAttraction getTouristAttractionByName(String name) {
        for (TouristAttraction touristAttraction:attractions) {
            if (touristAttraction.getName().equalsIgnoreCase(name)) {
                return touristAttraction;
            }
        }
        return null;
    }

    // ALL ATTRACTIONS
    public ArrayList<TouristAttraction> getAttractions() {
        return attractions;
    }

    // EDIT ATTRACTION
    public void editAttractionName(String attractionName, String newName) {
        TouristAttraction attraction = findAttraction(attractionName);
        if (attraction != null) {
            attraction.setName(newName);
        } else throw new IllegalArgumentException("No match found for your search on: " + attractionName);
    }
    public void editAttractionDescription(String attractionName, String newDescription) {

    }
    private TouristAttraction findAttraction(String attractionName) {
        for (TouristAttraction touristAttraction:attractions) {
            if(touristAttraction.getName().equalsIgnoreCase(attractionName)) {
                return touristAttraction;
            }
        }
        return null;
    }


}
