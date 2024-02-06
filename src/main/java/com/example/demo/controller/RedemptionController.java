package com.example.demo.controller;

import com.example.demo.dto.FamilyDto;
import com.example.demo.dto.PartnerDto;
import com.example.demo.dto.RedemptionDto;
import com.example.demo.service.FamilyService;
import com.example.demo.service.RedemptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membership/redemptions")
public class RedemptionController {
    private RedemptionService redemptionService;

    @Autowired
    public RedemptionController(RedemptionService redemptionService) {
        this.redemptionService = redemptionService;
    }

    @GetMapping
    public ResponseEntity<List<RedemptionDto>> getRedemptions() {
        return new ResponseEntity<>(redemptionService.getAllRedemptions(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<RedemptionDto> redemptionDetail(@PathVariable int id) {
        return ResponseEntity.ok(redemptionService.getRedemptionById(id));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<RedemptionDto> updateRedemptionId(@RequestBody RedemptionDto redemptionDto, @PathVariable("id") int redemptionId) {
        RedemptionDto response = redemptionService.updateRedemptionId(redemptionDto, redemptionId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RedemptionDto> createRedemption(@RequestBody RedemptionDto redemptionDto) {
        return new ResponseEntity<>(redemptionService.createRedemption(redemptionDto), HttpStatus.CREATED);
    }
}
