package com.data.couch.base.controller;

import com.data.couch.base.entity.Building;
import com.data.couch.base.service.BuildingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @PostMapping(value = "/buildings", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Building save(@Valid @RequestBody Building building){
        log.info("Saving Building={}", building);
        return buildingService.save(building);
    }

    @GetMapping(value = "/buildings/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Building findById(@PathVariable("id") String buildingId){
        log.info("Getting Building by id={}", buildingId);
        return buildingService.findById(buildingId);
    }

    @GetMapping(value = "/buildings", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Building> findAllBuildings(){
        log.info("Getting all buildings");
        return buildingService.findAllBuildings();
    }
}
