package com.example.demo.service;

import com.example.demo.dto.ClientDto;

import java.util.List;

public interface ClientService {

    ClientDto getClientById(int id);

//    ClientDto getClientByEmail(String email);
//
//    ClientDto getClientByPhone(String phone);

    ClientDto createClient(ClientDto clientDto);

    ClientDto updateClientId(ClientDto clientDto, int clientId);

//    ClientDto updateClientEmail(ClientDto clientDto, String clientEmail);
//
//    ClientDto updateClientPhone(ClientDto clientDto, String clientPhone);

    ClientDto deleteClientId(int clientId);

//    ClientDto deleteClientEmail(String clientEmail);
//
//    ClientDto deleteClientPhone(String clientPhone);

    List<ClientDto> getAllClients();

    List<ClientDto> getClientByFamilyId(int familyId);
}
