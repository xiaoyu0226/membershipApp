package com.example.demo.service.impl;

import com.example.demo.dto.FamilyDto;
import com.example.demo.dto.TreatmentDto;
import com.example.demo.dto.UserDto;
import com.example.demo.exceptions.PartnerNotFoundException;
import com.example.demo.exceptions.TreatmentNotFoundException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.helper.TreatmentHelper;
import com.example.demo.model.Family;
import com.example.demo.model.Partner;
import com.example.demo.model.Treatment;
import com.example.demo.model.User;
import com.example.demo.repository.TreatmentRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TreatmentService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TreatmentServiceImpl implements TreatmentService {
    private TreatmentRepository treatmentRepository;
    private final TreatmentHelper treatmentHelper = new TreatmentHelper();

    @Autowired
    public TreatmentServiceImpl(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

//    private TreatmentDto mapToDto(Treatment treatment) {
//        TreatmentDto treatmentDto = new TreatmentDto();
//        treatmentDto.setId(treatment.getId());
//        treatmentDto.setFamily(treatment.getFamily());
//        treatmentDto.setPartner(treatment.getPartner());
//        treatmentDto.setIsActive(treatment.getIsActive());
//        treatmentDto.setTreatmentName(treatment.getTreatmentName());
//        treatmentDto.setProviderName(treatment.getProviderName());
//        treatmentDto.setTimeLength(treatment.getTimeLength());
//        treatmentDto.setTokenNeeded(treatment.getTokenNeeded());
//
//        return treatmentDto;
//    }
//
//    private Treatment mapToEntity(TreatmentDto treatmentDto) {
//        Treatment treatment = new Treatment();
//        treatment.setId(treatmentDto.getId());
//        treatment.setFamily(treatmentDto.getFamily());
//        treatment.setPartner(treatmentDto.getPartner());
//        treatment.setIsActive(treatmentDto.getIsActive());
//        treatment.setTreatmentName(treatmentDto.getTreatmentName());
//        treatment.setProviderName(treatmentDto.getProviderName());
//        treatment.setTimeLength(treatmentDto.getTimeLength());
//        treatment.setTokenNeeded(treatmentDto.getTokenNeeded());
//        return treatment;
//    }

    @Override
    public List<TreatmentDto> getAllTreatments() {
        List<Treatment> treatments = treatmentRepository.findAll();
        List<TreatmentDto> treatmentDtos = treatments.stream().map(p -> this.treatmentHelper.mapToDto(p)).collect(Collectors.toList());
        return treatmentDtos;
    }

    @Override
    public TreatmentDto getTreatmentById(int id) {
        Treatment treatment = treatmentRepository.findById(id).orElseThrow(() -> new TreatmentNotFoundException("Treatment could not be found"));
        return this.treatmentHelper.mapToDto(treatment);
    }

    @Override
    public TreatmentDto createTreatment(TreatmentDto treatmentDto) {
        Treatment treatment = new Treatment();

        treatment.setFamily(treatmentDto.getFamily());

        Partner partner = new Partner();
        partner.setId(treatmentDto.getPartner_id());
        treatment.setPartner(partner);

        treatment.setIsActive(treatmentDto.getIsActive());
        treatment.setTreatmentName(treatmentDto.getTreatmentName());
        treatment.setProviderName(treatmentDto.getProviderName());
        treatment.setTimeLength(treatmentDto.getTimeLength());
        treatment.setTokenNeeded(treatmentDto.getTokenNeeded());
        treatmentRepository.save(treatment);
        return this.treatmentHelper.mapToDto(treatment);
    }

    @Override
    public TreatmentDto updateTreatmentId(TreatmentDto treatmentDto, int treatmentId) {
        Treatment treatment = treatmentRepository.findById(treatmentId).orElseThrow(() -> new TreatmentNotFoundException("Treatment could not be updated"));
        treatment.setFamily(treatmentDto.getFamily());

        Partner partner = new Partner();
        partner.setId(treatmentDto.getPartner_id());
        treatment.setPartner(partner);

        treatment.setIsActive(treatmentDto.getIsActive());
        treatment.setTreatmentName(treatmentDto.getTreatmentName());
        treatment.setProviderName(treatmentDto.getProviderName());
        treatment.setTimeLength(treatmentDto.getTimeLength());
        treatment.setTokenNeeded(treatmentDto.getTokenNeeded());

        Treatment updatedTreatment = treatmentRepository.save(treatment);
        return this.treatmentHelper.mapToDto(updatedTreatment);
    }

    @Override
    public TreatmentDto deleteTreatmentId(int treatmentId) {
        Treatment treatment = treatmentRepository.findById(treatmentId).orElseThrow(() -> new TreatmentNotFoundException("Treatment could not be updated"));
        treatment.setIsActive(false);

        Treatment updatedTreatment = treatmentRepository.save(treatment);
        return this.treatmentHelper.mapToDto(updatedTreatment);
    }
}
