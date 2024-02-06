package com.example.demo.service.impl;

import com.example.demo.dto.ClientDto;
import com.example.demo.dto.FamilyDto;
import com.example.demo.dto.PartnerDto;
import com.example.demo.dto.TreatmentDto;
import com.example.demo.exceptions.ClientNotFoundException;
import com.example.demo.exceptions.FamilyNotFoundException;
import com.example.demo.exceptions.PartnerNotFoundException;
import com.example.demo.helper.ClientHelper;
import com.example.demo.helper.FamilyHelper;
import com.example.demo.helper.PartnerHelper;
import com.example.demo.helper.TreatmentHelper;
import com.example.demo.model.Client;
import com.example.demo.model.Family;
import com.example.demo.model.Partner;
import com.example.demo.model.Treatment;
import com.example.demo.repository.FamilyRepository;
import com.example.demo.repository.PartnerRepository;
import com.example.demo.service.FamilyService;
import com.example.demo.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartnerServiceImpl implements PartnerService {
    private PartnerRepository partnerRepository;

    private final PartnerHelper partnerHelper = new PartnerHelper();
    private final TreatmentHelper treatmentHelper = new TreatmentHelper();

    @Autowired
    public PartnerServiceImpl(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

//    private PartnerDto mapToDto(Partner partner) {
//        PartnerDto partnerDto = new PartnerDto();
//        partnerDto.setId(partner.getId());
//        partnerDto.setAddress(partner.getAddress());
//        partnerDto.setIsActive(partner.getIsActive());
//        partnerDto.setTreatments(partner.getTreatments());
//        partnerDto.setClinicname(partner.getClinicname());
//        partnerDto.setEmail(partner.getEmail());
//        partnerDto.setPhone(partner.getPhone());
//        partnerDto.setUser(partner.getUser());
//        return partnerDto;
//    }
//
//    private Partner mapToEntity(PartnerDto partnerDto) {
//        Partner partner = new Partner();
//        partner.setId(partnerDto.getId());
//        partner.setAddress(partnerDto.getAddress());
//        partner.setIsActive(partnerDto.getIsActive());
//        partner.setTreatments(partnerDto.getTreatments());
//        partner.setClinicname(partnerDto.getClinicname());
//        partner.setEmail(partnerDto.getEmail());
//        partner.setPhone(partnerDto.getPhone());
//        partner.setUser(partnerDto.getUser());
//        return partner;
//    }

    @Override
    public List<PartnerDto> getAllPartners() {
        List<Partner> partners = partnerRepository.findAll();
        List<PartnerDto> partnerDtos = partners.stream().map(p -> this.partnerHelper.mapToDto(p)).collect(Collectors.toList());
        return partnerDtos;
    }

    @Override
    public PartnerDto getPartnerById(int id) {
        Partner partner = partnerRepository.findById(id).orElseThrow(() -> new PartnerNotFoundException("Partner could not be found"));
        return this.partnerHelper.mapToDto(partner);
    }

    @Override
    public PartnerDto getPartnerByEmail(String email) {
        Partner partner = partnerRepository.findByEmail(email).orElseThrow(() -> new PartnerNotFoundException("Partner could not be found"));
        return this.partnerHelper.mapToDto(partner);
    }

    @Override
    public PartnerDto getPartnerByClinicName(String clinicname) {
        Partner partner = partnerRepository.findByClinicname(clinicname).orElseThrow(() -> new PartnerNotFoundException("Partner could not be found"));
        return this.partnerHelper.mapToDto(partner);
    }

    @Override
    public PartnerDto createPartner(PartnerDto partnerDto) {
        Partner partner = new Partner();
        partner.setAddress(partnerDto.getAddress());
        partner.setIsActive(partnerDto.getIsActive());

        List<TreatmentDto> treatmentDtos = partnerDto.getTreatmentDtos();
        List<Treatment> treatments = treatmentDtos.stream().map(p -> this.treatmentHelper.mapToEntity(p)).collect(Collectors.toList());
        partner.setTreatments(treatments);

        partner.setClinicname(partnerDto.getClinicname());
        partner.setEmail(partnerDto.getEmail());
        partner.setPhone(partnerDto.getPhone());
        partner.setUser(partnerDto.getUser());
        partnerRepository.save(partner);
        return this.partnerHelper.mapToDto(partner);
    }

    @Override
    public PartnerDto updatePartnerId(PartnerDto partnerDto, int partnerId) {
        Partner partner = partnerRepository.findById(partnerId).orElseThrow(() -> new PartnerNotFoundException("Partner could not be updated"));

        partner.setAddress(partnerDto.getAddress());
        partner.setIsActive(partnerDto.getIsActive());

        List<TreatmentDto> treatmentDtos = partnerDto.getTreatmentDtos();
        List<Treatment> treatments = treatmentDtos.stream().map(p -> this.treatmentHelper.mapToEntity(p)).collect(Collectors.toList());
        partner.setTreatments(treatments);

        partner.setClinicname(partnerDto.getClinicname());
        partner.setEmail(partnerDto.getEmail());
        partner.setPhone(partnerDto.getPhone());
        partner.setUser(partnerDto.getUser());

        Partner updatedPartner = partnerRepository.save(partner);
        return this.partnerHelper.mapToDto(updatedPartner);
    }

    @Override
    public PartnerDto updatePartnerEmail(PartnerDto partnerDto, String partnerEmail) {
        Partner partner = partnerRepository.findByEmail(partnerEmail).orElseThrow(() -> new PartnerNotFoundException("Partner could not be updated"));

        partner.setAddress(partnerDto.getAddress());
        partner.setIsActive(partnerDto.getIsActive());

        List<TreatmentDto> treatmentDtos = partnerDto.getTreatmentDtos();
        List<Treatment> treatments = treatmentDtos.stream().map(p -> this.treatmentHelper.mapToEntity(p)).collect(Collectors.toList());
        partner.setTreatments(treatments);

        partner.setClinicname(partnerDto.getClinicname());
        partner.setEmail(partnerDto.getEmail());
        partner.setPhone(partnerDto.getPhone());
        partner.setUser(partnerDto.getUser());

        Partner updatedPartner = partnerRepository.save(partner);
        return this.partnerHelper.mapToDto(updatedPartner);
    }

    @Override
    public PartnerDto updatePartnerClinicName(PartnerDto partnerDto, String partnerName) {
        Partner partner = partnerRepository.findByClinicname(partnerName).orElseThrow(() -> new PartnerNotFoundException("Partner could not be updated"));

        partner.setAddress(partnerDto.getAddress());
        partner.setIsActive(partnerDto.getIsActive());

        List<TreatmentDto> treatmentDtos = partnerDto.getTreatmentDtos();
        List<Treatment> treatments = treatmentDtos.stream().map(p -> this.treatmentHelper.mapToEntity(p)).collect(Collectors.toList());
        partner.setTreatments(treatments);

        partner.setClinicname(partnerDto.getClinicname());
        partner.setEmail(partnerDto.getEmail());
        partner.setPhone(partnerDto.getPhone());
        partner.setUser(partnerDto.getUser());

        Partner updatedPartner = partnerRepository.save(partner);
        return this.partnerHelper.mapToDto(updatedPartner);
    }

    @Override
    public PartnerDto deletePartnerId(int partnerId) {
        Partner partner = partnerRepository.findById(partnerId).orElseThrow(() -> new PartnerNotFoundException("Partner could not be updated"));
        partner.setIsActive(false);

        Partner updatedPartner = partnerRepository.save(partner);
        return this.partnerHelper.mapToDto(updatedPartner);
    }

    @Override
    public PartnerDto deletePartnerEmail(String partnerEmail) {
        Partner partner = partnerRepository.findByEmail(partnerEmail).orElseThrow(() -> new PartnerNotFoundException("Partner could not be updated"));
        partner.setIsActive(false);

        Partner updatedPartner = partnerRepository.save(partner);
        return this.partnerHelper.mapToDto(updatedPartner);
    }

    @Override
    public PartnerDto deletePartnerClinicName(String partnerName) {
        Partner partner = partnerRepository.findByClinicname(partnerName).orElseThrow(() -> new PartnerNotFoundException("Partner could not be updated"));
        partner.setIsActive(false);

        Partner updatedPartner = partnerRepository.save(partner);
        return this.partnerHelper.mapToDto(updatedPartner);
    }
}
