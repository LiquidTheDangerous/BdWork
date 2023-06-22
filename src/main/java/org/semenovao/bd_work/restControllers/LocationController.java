package org.semenovao.bd_work.restControllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.semenovao.bd_work.domain.Location.Location;
import org.semenovao.bd_work.domain.Location.LocationAuditory;
import org.semenovao.bd_work.domain.Location.LocationAuditoryView;
import org.semenovao.bd_work.repository.LocationAuditoryViewRepository;
import org.semenovao.bd_work.service.Location.LocationAuditoryService;
import org.semenovao.bd_work.service.Location.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    private final LocationService locationService;
    private final LocationAuditoryService locationAuditoryService;

    private final LocationAuditoryViewRepository locationAuditoryViewRepository;

    public LocationController(LocationService locationService, LocationAuditoryService locationAuditoryService, LocationAuditoryViewRepository locationAuditoryViewRepository) {
        this.locationService = locationService;
        this.locationAuditoryService = locationAuditoryService;
        this.locationAuditoryViewRepository = locationAuditoryViewRepository;
    }

    @GetMapping("/fullDescription/getAll")
    List<LocationAuditoryView> getAllFullDescription(){
        return locationAuditoryViewRepository.findAll();
    }

    @GetMapping("/getAll")
    List<Location> getAll(){
        return locationService.getAll();
    }

    @PostMapping("/create")
    ResponseEntity<Location> create(@RequestBody Location location){
        return new ResponseEntity<Location>(locationService.save(location), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Location> update(@PathVariable("id") Long id,@RequestBody Location location){
        location.setId(id);
        return new ResponseEntity<Location>(locationService.update(location),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Location> delete(@PathVariable("id") Long id){
        locationService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/auditory/getAll")
    List<LocationAuditory> getAllAuditory(){
        return locationAuditoryService.getAll();
    }

    @PostMapping("/auditory/create")
    ResponseEntity<LocationAuditory> createAuditory(@RequestBody LocationAuditory locationAuditory){
        return new ResponseEntity<LocationAuditory>(locationAuditoryService.save(locationAuditory),HttpStatus.OK);
    }

    @PutMapping("/auditory/update/{id}")
    ResponseEntity<LocationAuditory> updateAuditory(@PathVariable("id") Long id, @RequestBody LocationAuditory locationAuditory){
        locationAuditory.setId(id);
        return new ResponseEntity<LocationAuditory>(locationAuditoryService.update(locationAuditory),HttpStatus.OK);
    }

    @DeleteMapping("/auditory/delete/{id}")
    ResponseEntity<LocationAuditory> deleteAuditory(@PathVariable("id") Long id){
        locationAuditoryService.delete(id);
        return new ResponseEntity<LocationAuditory>(HttpStatus.OK);
    }

}
