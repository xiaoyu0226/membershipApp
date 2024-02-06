package com.example.demo.service.impl;

import com.example.demo.dto.ClientDto;
import com.example.demo.dto.FamilyDto;
import com.example.demo.exceptions.ClientNotFoundException;
import com.example.demo.exceptions.FamilyNotFoundException;
import com.example.demo.helper.ClientHelper;
import com.example.demo.helper.FamilyHelper;
import com.example.demo.model.Client;
import com.example.demo.model.Family;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.FamilyRepository;
import com.example.demo.service.ClientService;
import com.example.demo.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FamilyServiceImpl implements FamilyService {
    private FamilyRepository familyRepository;
    private ClientHelper clientHelper = new ClientHelper();
    private FamilyHelper familyHelper = new FamilyHelper();

    @Autowired
    public FamilyServiceImpl(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }
    @Override
    public List<FamilyDto> getAllFamilies() {
        List<Family> families = familyRepository.findAll();
        List<FamilyDto> familyDtos = families.stream().map(p -> familyHelper.mapToDto(p)).collect(Collectors.toList());
        return familyDtos;
    }

    @Override
    public FamilyDto getFamilyById(int id) {
        Family family = familyRepository.findById(id).orElseThrow(() -> new FamilyNotFoundException("Family could not be found"));
        return familyHelper.mapToDto(family);
    }

//    @Override
//    public List<FamilyDto> getFamilyByName(String name) {
//        Optional<List<Family>> families = familyRepository.findByName(name);
//        List<FamilyDto> familyDtos = families.stream().map(p -> mapToDto((Family) p)).collect(Collectors.toList());
//        return familyDtos;
//    }

    @Override
    public FamilyDto getFamilyByEmail(String email) {
        Family family = familyRepository.findByEmail(email).orElseThrow(() -> new FamilyNotFoundException("Family could not be found"));
        return familyHelper.mapToDto(family);
    }

    @Override
    public FamilyDto createFamily(FamilyDto familyDto) {
        Family family = new Family();
        List<ClientDto> clientDtos = familyDto.getClientsDto();
        List<Client> clients = clientDtos.stream().map(p -> clientHelper.mapToEntity(p)).collect(Collectors.toList());
        family.setClients(clients);
        family.setIsActive(familyDto.getIsActive());
        family.setName(familyDto.getName());
        family.setTokens(familyDto.getTokens());
        family.setMembershipLevel(familyDto.getMembershipLevel());
        family.setTreatments(familyDto.getTreatments());
        family.setEmail(familyDto.getEmail());
        familyRepository.save(family);
        return familyHelper.mapToDto(family);
    }

    @Override
    public FamilyDto updateFamilyId(FamilyDto familyDto, int familyId) {
        Family family = familyRepository.findById(familyId).orElseThrow(() -> new FamilyNotFoundException("Client could not be updated"));

        List<ClientDto> clientDtos = familyDto.getClientsDto();
        List<Client> clients = clientDtos.stream().map(p -> clientHelper.mapToEntity(p)).collect(Collectors.toList());
        family.setClients(clients);

        family.setIsActive(familyDto.getIsActive());
        family.setName(familyDto.getName());
        family.setTokens(familyDto.getTokens());
        family.setMembershipLevel(familyDto.getMembershipLevel());
        family.setTreatments(familyDto.getTreatments());
        family.setEmail(familyDto.getEmail());

        Family updatedFamily = familyRepository.save(family);
        return familyHelper.mapToDto(updatedFamily);
    }

    @Override
    public FamilyDto deleteFamilyId(int familyId) {
        Family family = familyRepository.findById(familyId).orElseThrow(() -> new FamilyNotFoundException("Family could not be updated"));
        family.setIsActive(false);

        Family updatedFamily = familyRepository.save(family);
        return familyHelper.mapToDto(updatedFamily);
    }

    @Override
    public FamilyDto deleteFamilyEmail(String familyEmail) {
        Family family = familyRepository.findByEmail(familyEmail).orElseThrow(() -> new FamilyNotFoundException("Family could not be updated"));
        family.setIsActive(false);

        Family updatedFamily = familyRepository.save(family);
        return familyHelper.mapToDto(updatedFamily);
    }

    @Override
    public FamilyDto updateFamilyEmail(FamilyDto familyDto, String familyEmail) {
        Family family = familyRepository.findByEmail(familyEmail).orElseThrow(() -> new FamilyNotFoundException("Family could not be updated"));

        List<ClientDto> clientDtos = familyDto.getClientsDto();
        List<Client> clients = clientDtos.stream().map(p -> clientHelper.mapToEntity(p)).collect(Collectors.toList());
        family.setClients(clients);

        family.setIsActive(familyDto.getIsActive());
        family.setName(familyDto.getName());
        family.setTokens(familyDto.getTokens());

        family.setMembershipLevel(familyDto.getMembershipLevel());
        family.setTreatments(familyDto.getTreatments());
        family.setEmail(familyDto.getEmail());

        Family updatedFamily = familyRepository.save(family);
        return familyHelper.mapToDto(updatedFamily);
    }

//    private FamilyDto mapToDto(Family family) {
//        FamilyDto familyDto = new FamilyDto();
//        familyDto.setId(family.getId());
//
//        List<Client> clients = family.getClients();
//        List<ClientDto> clientDtos = clients.stream().map(p -> clientHelper.mapToDto(p)).collect(Collectors.toList());
//
//        familyDto.setClientsDto(clientDtos);
//        familyDto.setIsActive(family.getIsActive());
//        familyDto.setName(family.getName());
//        familyDto.setTokens(family.getTokens());
//        familyDto.setExpiredAt(family.getExpiredAt());
//        familyDto.setJoinedAt(family.getJoinedAt());
//        familyDto.setMembershipLevel(family.getMembershipLevel());
//        familyDto.setTreatments(family.getTreatments());
//        familyDto.setEmail(family.getEmail());
//        return familyDto;
//    }
//
//    private Family mapToEntity(FamilyDto familyDto) {
//        Family family = new Family();
//        family.setId(familyDto.getId());
//
//        List<ClientDto> clientDtos = familyDto.getClientsDto();
//        List<Client> clients = clientDtos.stream().map(p -> clientHelper.mapToEntity(p)).collect(Collectors.toList());
//        family.setClients(clients);
//
//        family.setIsActive(familyDto.getIsActive());
//        family.setName(familyDto.getName());
//        family.setTokens(familyDto.getTokens());
//        family.setExpiredAt(familyDto.getExpiredAt());
//        family.setJoinedAt(familyDto.getJoinedAt());
//        family.setMembershipLevel(familyDto.getMembershipLevel());
//        family.setTreatments(familyDto.getTreatments());
//        family.setEmail(familyDto.getEmail());
//        return family;
//    }
}
