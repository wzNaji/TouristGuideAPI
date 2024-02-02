package com.first.touristguideapi.controller;

import com.first.touristguideapi.Service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("attractions")
public class TouristController {

    private final TouristService touristService;
    @Autowired
    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }
}
