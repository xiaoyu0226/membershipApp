package com.example.demo.service;

import com.example.demo.dto.ClientDto;
import com.example.demo.dto.FamilyDto;
import com.example.demo.dto.PartnerDto;

import java.util.List;

public interface PartnerService {

    List<PartnerDto> getAllPartners();

    PartnerDto getPartnerById(int id);

    PartnerDto getPartnerByEmail(String email);

    PartnerDto getPartnerByClinicName(String clinicname);

    PartnerDto createPartner(PartnerDto partnerDto);

    PartnerDto updatePartnerId(PartnerDto partnerDto, int partnerId);

    PartnerDto updatePartnerEmail(PartnerDto partnerDto, String partnerEmail);

    PartnerDto updatePartnerClinicName(PartnerDto partnerDto, String partnerName);

    PartnerDto deletePartnerId(int partnerId);

    PartnerDto deletePartnerEmail(String partnerEmail);

    PartnerDto deletePartnerClinicName(String partnerName);
}
