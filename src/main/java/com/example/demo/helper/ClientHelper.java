package com.example.demo.helper;

import com.example.demo.dto.ClientDto;
import com.example.demo.model.Client;
import com.example.demo.model.Family;

public class ClientHelper {
    public ClientDto mapToDto(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setAddress(client.getAddress());
        clientDto.setBirthday(client.getBirthday());
        clientDto.setEmail(client.getEmail());
//        clientDto.setFamily(client.getFamily());
        clientDto.setFamily_id(client.getFamily().getId());
        clientDto.setFirstname(client.getFirstname());
        clientDto.setLastname(client.getLastname());
        clientDto.setPhone(client.getPhone());
        clientDto.setUser(client.getUser());
        clientDto.setIsActive(client.getIsActive());
        clientDto.setPassword(client.getPassword());
        return clientDto;
    }

    public Client mapToEntity(ClientDto clientDto) {
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setAddress(clientDto.getAddress());
        client.setBirthday(clientDto.getBirthday());
        client.setEmail(clientDto.getEmail());
//        client.setFamily(clientDto.getFamily());

        Family family = new Family();
        family.setId(clientDto.getFamily_id());
        client.setFamily(family);

        client.setFirstname(clientDto.getFirstname());
        client.setLastname(clientDto.getLastname());
        client.setPhone(clientDto.getPhone());
        client.setUser(clientDto.getUser());
        client.setIsActive(clientDto.getIsActive());
        client.setPassword(clientDto.getPassword());
        return client;
    }
}
