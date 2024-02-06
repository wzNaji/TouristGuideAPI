package com.first.touristguideapi.controller;

import com.first.touristguideapi.Service.TouristService;
import com.first.touristguideapi.model.TouristAttraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("attractions")
public class TouristController {

    private final TouristService touristService;
    @Autowired
    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    // ADD ATTRACTION (lavet om til at tage 2 Strings (name, description), i stedet for et objekt)
    @PostMapping("/add")
    public ResponseEntity<Void> addTouristAttraction(@RequestParam TouristAttraction touristAttraction) {
        touristService.addAttraction(touristAttraction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // REMOVE ATTRACTION
    @GetMapping("/delete/{name}")
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
    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateAttraction(@RequestBody TouristAttraction touristAttraction) {
        TouristAttraction touristAttraction1 = touristService.updateAttraction(touristAttraction);
        if (touristAttraction1 != null) {
            return new ResponseEntity<TouristAttraction>(touristAttraction1, HttpStatus.OK);
        }
        return new ResponseEntity<TouristAttraction>(new TouristAttraction("Error", "Not Found"),HttpStatus.NOT_FOUND);
    }

}
