package com.first.touristguideapi.Service;

import com.first.touristguideapi.model.TouristAttraction;
import com.first.touristguideapi.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TouristService {

    private final TouristRepository touristRepository;
    @Autowired
    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    // ADD
    public void addAttraction(TouristAttraction touristAttraction) {
        touristRepository.addTouristAttraction(touristAttraction);
    }

    // REMOVE
    public void removeAttraction(TouristAttraction touristAttraction) {
        touristRepository.removeTouristAttraction(touristAttraction);
    }

    // GET SPECIFIC ATTRACTION
    public TouristAttraction getTouristAttractionByName(String name) {
        return touristRepository.getTouristAttractionByName(name);
    }

    // GET ALL ATTRACTIONS
    public ArrayList<TouristAttraction> getAttractions() {
        return touristRepository.getAttractions();
    }

    // EDIT ATTRACTION
    public void editAttractionName(String attractionName, String newName) {
        touristRepository.editAttractionName(attractionName, newName);
    }
    public void editAttractionDescription(String attractionName, String newName) {
        touristRepository.editAttractionDescription(attractionName, newName);
    }



}
