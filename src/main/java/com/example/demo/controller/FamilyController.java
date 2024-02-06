package com.example.demo.controller;

import com.example.demo.dto.ClientDto;
import com.example.demo.dto.FamilyDto;
import com.example.demo.model.Client;
import com.example.demo.service.ClientService;
import com.example.demo.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membership/families")
public class FamilyController {
    private FamilyService familyService;

    @Autowired
    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    @GetMapping
    public ResponseEntity<List<FamilyDto>> getFamilies() {
        return new ResponseEntity<>(familyService.getAllFamilies(), HttpStatus.OK);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<FamilyDto> familyDetail(@PathVariable int id) {
        return ResponseEntity.ok(familyService.getFamilyById(id));
    }

//    @GetMapping("{name}")
//    public ResponseEntity<List<FamilyDto>> familyDetailByName(@PathVariable String name) {
//        return ResponseEntity.ok(familyService.getFamilyByName(name));
//    }

    @GetMapping("email/{email}")
    public ResponseEntity<FamilyDto> familyDetailByEmail(@PathVariable String email) {
        return ResponseEntity.ok(familyService.getFamilyByEmail(email));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<FamilyDto> createFamily(@RequestBody FamilyDto familyDto) {
        return new ResponseEntity<>(familyService.createFamily(familyDto), HttpStatus.CREATED);
    }

    @PutMapping("id/{id}/update")
    public ResponseEntity<FamilyDto> updateFamilyId(@RequestBody FamilyDto familyDto, @PathVariable("id") int familyId) {
        FamilyDto response = familyService.updateFamilyId(familyDto, familyId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("email/{email}/update")
    public ResponseEntity<FamilyDto> updateFamilyEmail(@RequestBody FamilyDto familyDto, @PathVariable("email") String familyEmail) {
        FamilyDto response = familyService.updateFamilyEmail(familyDto, familyEmail);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("email/{email}/delete")
    public ResponseEntity<String> deleteFamilyEmail(@PathVariable("email") String familyEmail) {
        familyService.deleteFamilyEmail(familyEmail);
        return new ResponseEntity<>("Family delete", HttpStatus.OK);
    }

    @DeleteMapping("id/{id}/delete")
    public ResponseEntity<String> deleteFamily(@PathVariable("id") int familyId) {
        familyService.deleteFamilyId(familyId);
        return new ResponseEntity<>("Family delete", HttpStatus.OK);
    }

}

