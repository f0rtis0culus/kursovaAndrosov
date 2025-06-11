package com.example.demo.controllers;

import com.example.demo.entities.Facility;
import com.example.demo.repositories.FacilityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facilities")
public class FacilityController {

  private final FacilityRepository facilityRepository;

  public FacilityController(FacilityRepository facilityRepository) {
    this.facilityRepository = facilityRepository;
  }

  @GetMapping
  public List<Facility> getAll() {
    return facilityRepository.findAll();
  }

  @PostMapping
  public Facility create(@RequestBody Facility facility) {
    return facilityRepository.save(facility);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    facilityRepository.deleteById(id);
  }
}
