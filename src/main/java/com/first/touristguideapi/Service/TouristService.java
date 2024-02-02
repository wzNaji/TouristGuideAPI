package com.first.touristguideapi.Service;

import com.first.touristguideapi.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TouristService {

    private final TouristRepository touristRepository;
    @Autowired
    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }



}
