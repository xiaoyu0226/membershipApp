package com.example.demo.service;

import com.example.demo.dto.PartnerDto;
import com.example.demo.dto.RedemptionDto;

import java.util.List;

public interface RedemptionService {
    RedemptionDto createRedemption(RedemptionDto redemptionDto);

    List<RedemptionDto> getAllRedemptions();

    RedemptionDto getRedemptionById(int id);

    RedemptionDto updateRedemptionId(RedemptionDto redemptionDto, int redemptionId);
}
