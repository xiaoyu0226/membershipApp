package com.example.demo.helper;

import com.example.demo.dto.ClientDto;
import com.example.demo.dto.FamilyDto;
import com.example.demo.model.Client;
import com.example.demo.model.Family;

import java.util.List;
import java.util.stream.Collectors;

public class FamilyHelper {

    private final ClientHelper clientHelper;

    public FamilyHelper() {
        this.clientHelper = new ClientHelper();
    }
    public FamilyDto mapToDto(Family family) {
        FamilyDto familyDto = new FamilyDto();
        familyDto.setId(family.getId());

        List<Client> clients = family.getClients();
        List<ClientDto> clientDtos = clients.stream().map(p -> this.clientHelper.mapToDto(p)).collect(Collectors.toList());

        familyDto.setClientsDto(clientDtos);
        familyDto.setIsActive(family.getIsActive());
        familyDto.setName(family.getName());
        familyDto.setTokens(family.getTokens());

        familyDto.setMembershipLevel(family.getMembershipLevel());
        familyDto.setTreatments(family.getTreatments());
        familyDto.setEmail(family.getEmail());
        return familyDto;
    }

    public Family mapToEntity(FamilyDto familyDto) {
        Family family = new Family();
        family.setId(familyDto.getId());

        List<ClientDto> clientDtos = familyDto.getClientsDto();
        List<Client> clients = clientDtos.stream().map(p -> this.clientHelper.mapToEntity(p)).collect(Collectors.toList());
        family.setClients(clients);

        family.setIsActive(familyDto.getIsActive());
        family.setName(familyDto.getName());
        family.setTokens(familyDto.getTokens());
        family.setMembershipLevel(familyDto.getMembershipLevel());
        family.setTreatments(familyDto.getTreatments());
        family.setEmail(familyDto.getEmail());
        return family;
    }
}
