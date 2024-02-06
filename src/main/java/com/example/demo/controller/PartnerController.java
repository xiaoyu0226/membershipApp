package com.example.demo.controller;

import com.example.demo.dto.ClientDto;
import com.example.demo.dto.FamilyDto;
import com.example.demo.dto.PartnerDto;
import com.example.demo.model.Client;
import com.example.demo.service.ClientService;
import com.example.demo.service.FamilyService;
import com.example.demo.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membership/partners")
public class PartnerController {

    private PartnerService partnerService;

    @Autowired
    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @GetMapping
    public ResponseEntity<List<PartnerDto>> getPartners() {
        return new ResponseEntity<>(partnerService.getAllPartners(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<PartnerDto> partnerDetail(@PathVariable int id) {
        return ResponseEntity.ok(partnerService.getPartnerById(id));

    }

    @GetMapping("{email}")
    public ResponseEntity<PartnerDto> partnerDetailByEmail(@PathVariable String email) {
        return ResponseEntity.ok(partnerService.getPartnerByEmail(email));
    }

    @GetMapping("{clinicname}")
    public ResponseEntity<PartnerDto> partnerDetailByClinicName(@PathVariable String clinicname) {
        return ResponseEntity.ok(partnerService.getPartnerByClinicName(clinicname));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PartnerDto> createPartner(@RequestBody PartnerDto partnerDto) {
        return new ResponseEntity<>(partnerService.createPartner(partnerDto), HttpStatus.CREATED);
    }

    @PutMapping("/id/{id}/update")
    public ResponseEntity<PartnerDto> updatePartnerId(@RequestBody PartnerDto partnerDto, @PathVariable("id") int partnerId) {
        PartnerDto response = partnerService.updatePartnerId(partnerDto, partnerId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/email/{email}/update")
    public ResponseEntity<PartnerDto> updatePartnerEmail(@RequestBody PartnerDto partnerDto, @PathVariable("email") String partnerEmail) {
        PartnerDto response = partnerService.updatePartnerEmail(partnerDto, partnerEmail);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/clinicname/{clinicname}/update")
    public ResponseEntity<PartnerDto> updatePartnerClinicName(@RequestBody PartnerDto partnerDto, @PathVariable("clinicname") String partnerName) {
        PartnerDto response = partnerService.updatePartnerClinicName(partnerDto, partnerName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}/delete")
    public ResponseEntity<String> deletePartner(@PathVariable("id") int partnerId) {
        partnerService.deletePartnerId(partnerId);
        return new ResponseEntity<>("Partner delete", HttpStatus.OK);
    }

    @DeleteMapping("/email/{email}/delete")
    public ResponseEntity<String> deletePartnerEmail(@PathVariable("email") String partnerEmail) {
        partnerService.deletePartnerEmail(partnerEmail);
        return new ResponseEntity<>("Partner delete", HttpStatus.OK);
    }

    @DeleteMapping("/clinicname/{clinicname}/delete")
    public ResponseEntity<String> deletePartnerClinicName(@PathVariable("clinicname") String partnerName) {
        partnerService.deletePartnerClinicName(partnerName);
        return new ResponseEntity<>("Partner delete", HttpStatus.OK);
    }
}
