package com.example.demo.controller;

import com.example.demo.dto.FamilyDto;
import com.example.demo.dto.TreatmentDto;
import com.example.demo.service.FamilyService;
import com.example.demo.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membership/treatments")
public class TreatmentController {
    private TreatmentService treatmentService;

    @Autowired
    public TreatmentController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping
    public ResponseEntity<List<TreatmentDto>> getTreatments() {
        return new ResponseEntity<>(treatmentService.getAllTreatments(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<TreatmentDto> treatmentDetail(@PathVariable int id) {
        return ResponseEntity.ok(treatmentService.getTreatmentById(id));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TreatmentDto> createTreatment(@RequestBody TreatmentDto treatmentDto) {
        return new ResponseEntity<>(treatmentService.createTreatment(treatmentDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<TreatmentDto> updateTreatmentId(@RequestBody TreatmentDto treatmentDto, @PathVariable("id") int treatmentId) {
        TreatmentDto response = treatmentService.updateTreatmentId(treatmentDto, treatmentId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteTreatment(@PathVariable("id") int treatmentId) {
        treatmentService.deleteTreatmentId(treatmentId);
        return new ResponseEntity<>("Treatment delete", HttpStatus.OK);
    }

    // add more for get treatment by partner
    // check if one to many needs to be change to many to many
}
