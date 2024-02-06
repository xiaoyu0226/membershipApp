package com.example.demo.helper;

import com.example.demo.dto.ClientDto;
import com.example.demo.dto.FamilyDto;
import com.example.demo.dto.PartnerDto;
import com.example.demo.dto.TreatmentDto;
import com.example.demo.model.Client;
import com.example.demo.model.Family;
import com.example.demo.model.Partner;
import com.example.demo.model.Treatment;

import java.util.List;
import java.util.stream.Collectors;

public class PartnerHelper {

    private final TreatmentHelper treatmentHelper;

    public PartnerHelper() {
        this.treatmentHelper = new TreatmentHelper();
    }


    public PartnerDto mapToDto(Partner partner) {
        PartnerDto partnerDto = new PartnerDto();
        partnerDto.setId(partner.getId());
        partnerDto.setAddress(partner.getAddress());
        partnerDto.setIsActive(partner.getIsActive());

        List<Treatment> treatments = partner.getTreatments();
        List<TreatmentDto> treatmentDtos = treatments.stream().map(p -> this.treatmentHelper.mapToDto(p)).collect(Collectors.toList());

        partnerDto.setTreatmentDtos(treatmentDtos);
        partnerDto.setClinicname(partner.getClinicname());
        partnerDto.setEmail(partner.getEmail());
        partnerDto.setPhone(partner.getPhone());
        partnerDto.setUser(partner.getUser());
        return partnerDto;
    }

    public Partner mapToEntity(PartnerDto partnerDto) {
        Partner partner = new Partner();
        partner.setId(partnerDto.getId());
        partner.setAddress(partnerDto.getAddress());
        partner.setIsActive(partnerDto.getIsActive());

        List<TreatmentDto> treatmentDtos = partnerDto.getTreatmentDtos();
        List<Treatment> treatments = treatmentDtos.stream().map(p -> this.treatmentHelper.mapToEntity(p)).collect(Collectors.toList());
        partner.setTreatments(treatments);
//        partner.setTreatments(partnerDto.getTreatments());
        partner.setClinicname(partnerDto.getClinicname());
        partner.setEmail(partnerDto.getEmail());
        partner.setPhone(partnerDto.getPhone());
        partner.setUser(partnerDto.getUser());
        return partner;
    }

}
