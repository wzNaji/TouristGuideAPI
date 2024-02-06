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


    public void removeTouristAttraction(TouristAttraction touristAttraction) {
        TouristAttraction attractionToDelete = null;
        for (TouristAttraction touristAttraction1:attractions) {
            if (touristAttraction1.equals(touristAttraction)) {
                attractionToDelete = touristAttraction1;
            }
        }
        attractions.remove(attractionToDelete);
    }



    // GET SPECIFIC ATTRACTION
    public TouristAttraction getTouristAttractionByName(String name) {
        for (TouristAttraction touristAttraction:attractions) {
            if (touristAttraction.getName().equalsIgnoreCase(name)) {
                return touristAttraction;
            }
        }
        return null;
    }

    // GET ALL ATTRACTIONS
    public ArrayList<TouristAttraction> getAttractions() {
        return attractions;
    }

    // EDIT ATTRACTION

    public TouristAttraction updateAttraction(TouristAttraction touristAttraction) {
        if (findAttraction(touristAttraction)) {
            return touristAttraction;
        }
        return null;
    }
    private Boolean findAttraction(TouristAttraction touristAttraction) {
        for (TouristAttraction touristAttraction1:attractions) {
            if(touristAttraction.getName().equalsIgnoreCase(touristAttraction1.getName()) &&
            touristAttraction.getDescription().equalsIgnoreCase(touristAttraction1.getDescription())) {
                return true;
            }
        }
        return false;
    }


}
