package com.first.touristguideapi.controller;

import com.first.touristguideapi.Service.TouristService;
import com.first.touristguideapi.model.TouristAttraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("attractions")
public class TouristController {

    private final TouristService touristService;
    @Autowired
    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    // ADD ATTRACTION
    @PostMapping
    public ResponseEntity<Void> addTouristAttraction(@RequestBody @Validated TouristAttraction attraction) {
        touristService.addAttraction(attraction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // REMOVE ATTRACTION
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> removeTouristAttraction(@PathVariable String name) {
        TouristAttraction attraction = touristService.getTouristAttractionByName(name);
        if (attraction != null) {
            touristService.removeAttraction(attraction);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // GET SPECIFIC ATTRACTION
    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getTouristAttractionByName(@PathVariable String name) {
        TouristAttraction attraction = touristService.getTouristAttractionByName(name);
        if (attraction != null) {
            return new ResponseEntity<>(attraction, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // GET ALL ATTRACTIONS
    @GetMapping
    public ResponseEntity<List<TouristAttraction>> getAllAttractions() {
        return new ResponseEntity<>(touristService.getAttractions(), HttpStatus.OK);
    }

    // EDIT ATTRACTION NAME
    @PutMapping("/{name}/editName")
    public ResponseEntity<Void> editAttractionName(@PathVariable String name, @RequestParam String newName) {
        try {
            touristService.editAttractionName(name, newName);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // EDIT ATTRACTION DESCRIPTION
    @PutMapping("/{name}/editDescription")
    public ResponseEntity<Void> editAttractionDescription(@PathVariable String name, @RequestParam String newDescription) {
        try {
            touristService.editAttractionDescription(name, newDescription);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
