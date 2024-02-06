package com.example.demo.service.impl;

import com.example.demo.dto.RedemptionDto;
import com.example.demo.exceptions.RedemptionNotFoundException;
import com.example.demo.helper.FamilyHelper;
import com.example.demo.helper.RedemptionHelper;
import com.example.demo.helper.TreatmentHelper;
import com.example.demo.model.Family;
import com.example.demo.model.Redemption;
import com.example.demo.model.Treatment;
import com.example.demo.repository.RedemptionRepository;
import com.example.demo.service.RedemptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RedemptionServiceImpl implements RedemptionService {
    private RedemptionRepository redemptionRepository;

    private final RedemptionHelper redemptionHelper = new RedemptionHelper();

    @Autowired
    public RedemptionServiceImpl(RedemptionRepository redemptionRepository) {
        this.redemptionRepository = redemptionRepository;
    }

//    private RedemptionDto mapToDto(Redemption redemption) {
//        RedemptionDto redemptionDto = new RedemptionDto();
//        redemptionDto.setId(redemption.getId());
//        redemptionDto.setRedemptionDate(redemption.getRedemptionDate());
//        redemptionDto.setFamily(redemption.getFamily());
//        redemptionDto.setTreatment(redemption.getTreatment());
//        redemptionDto.setTokenConsumed(redemption.getTokenConsumed());
//        return redemptionDto;
//    }
//
//    private Redemption mapToEntity(RedemptionDto redemptionDto) {
//        Redemption redemption = new Redemption();
//        redemption.setId(redemptionDto.getId());
//        redemption.setRedemptionDate(redemptionDto.getRedemptionDate());
//        redemption.setFamily(redemptionDto.getFamily());
//        redemption.setTreatment(redemptionDto.getTreatment());
//        redemption.setTokenConsumed(redemptionDto.getTokenConsumed());
//        return redemption;
//    }

    @Override
    public RedemptionDto createRedemption(RedemptionDto redemptionDto) {
        Redemption redemption = new Redemption();

        Family family = new Family();
        family.setId(redemptionDto.getFamily_id());

        Treatment treatment = new Treatment();
        treatment.setId(redemptionDto.getTreatment_id());

        redemption.setFamily(family);
        redemption.setTreatment(treatment);

        redemption.setTokenConsumed(redemptionDto.getTokenConsumed());
        redemptionRepository.save(redemption);
        return redemptionDto;
    }

    @Override
    public List<RedemptionDto> getAllRedemptions() {
        List<Redemption> redemptions = redemptionRepository.findAll();
        List<RedemptionDto> redemptionDtos = redemptions.stream().map(p -> this.redemptionHelper.mapToDto(p)).collect(Collectors.toList());
        return redemptionDtos;
    }

    @Override
    public RedemptionDto getRedemptionById(int id) {
        Redemption redemption = redemptionRepository.findById(id).orElseThrow(() -> new RedemptionNotFoundException("Redemption could not be found"));
        return this.redemptionHelper.mapToDto(redemption);
    }

    @Override
    public RedemptionDto updateRedemptionId(RedemptionDto redemptionDto, int redemptionId) {
        Redemption redemption = redemptionRepository.findById(redemptionId).orElseThrow(() -> new RedemptionNotFoundException("Redemption could not be updated"));

        Family family = new Family();
        family.setId(redemptionDto.getFamily_id());

        Treatment treatment = new Treatment();
        treatment.setId(redemptionDto.getTreatment_id());

        redemption.setFamily(family);
        redemption.setTreatment(treatment);

        redemption.setTokenConsumed(redemptionDto.getTokenConsumed());

        Redemption updatedRedemption = redemptionRepository.save(redemption);
        return this.redemptionHelper.mapToDto(updatedRedemption);
    }
}
