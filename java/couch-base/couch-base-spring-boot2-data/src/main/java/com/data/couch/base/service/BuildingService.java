package com.data.couch.base.service;

import com.data.couch.base.entity.Building;
import com.data.couch.base.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    public Building save(Building building){
        building = buildingRepository.save(building);

        return building;
    }

    public Building findById(String buildingId){
        Optional<Building> buildingOptional = buildingRepository.findById(buildingId);
        return buildingOptional.orElseThrow(() -> new RuntimeException("building not found by id="+buildingId));
    }

    public Iterable<Building> findAllBuildings(){
        Iterable<Building> buildings = buildingRepository.findAll();
        return buildings;
    }
}
