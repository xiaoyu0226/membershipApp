package com.example.demo.service.impl;

import com.example.demo.dto.ClientDto;
import com.example.demo.exceptions.ClientNotFoundException;
import com.example.demo.helper.ClientHelper;
import com.example.demo.model.Client;
import com.example.demo.model.Family;
import com.example.demo.model.User;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;

    private ClientHelper clientHelper = new ClientHelper();

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public ClientDto getClientById(int id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("Client could not be found"));
        return clientHelper.mapToDto(client);
    }

//    @Override
//    public ClientDto getClientByEmail(String email) {
//        Client client = clientRepository.findByEmail(email).orElseThrow(() -> new ClientNotFoundException("Client could not be found"));
//        return mapToDto(client);
//    }
//
//    @Override
//    public ClientDto getClientByPhone(String phone) {
//        Client client = clientRepository.findByPhone(phone).orElseThrow(() -> new ClientNotFoundException("Client could not be found"));
//        return mapToDto(client);
//    }

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        Client client = new Client();

//        // If the client has a family, and the family is detached, reattach it
//        if (clientDto.getFamily() != null && !entityManager.contains(mapToEntity(clientDto).getFamily())) {
//            client.setFamily(reattachFamily(clientDto.getFamily()));
//        }
//
//        // If the client has a family, and the family is detached, reattach it
//        if (clientDto.getUser() != null && !entityManager.contains(mapToEntity(clientDto).getUser())) {
//            client.setUser(reattachUser(clientDto.getUser()));
//        }

        client.setAddress(clientDto.getAddress());
        client.setBirthday(clientDto.getBirthday());
        client.setEmail(clientDto.getEmail());
//        client.setFamily(clientDto.getFamily());
        client.setFirstname(clientDto.getFirstname());
        client.setLastname(clientDto.getLastname());
        client.setPhone(clientDto.getPhone());
//        client.setUser(clientDto.getUser());
        client.setIsActive(clientDto.getIsActive());
        client.setPassword(clientDto.getPassword());

        Family family = new Family();
        family.setId(clientDto.getFamily_id());
        System.out.println(clientDto.getFamily_id());
        client.setFamily(family);

        client.setUser(clientDto.getUser());
        clientRepository.save(client);
        return this.clientHelper.mapToDto(client);
    }

    @Override
    public ClientDto updateClientId(ClientDto clientDto, int clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException("Client could not be updated"));

//        // If the client has a family, and the family is detached, reattach it
//        if (clientDto.getFamily() != null && !entityManager.contains(mapToEntity(clientDto).getFamily())) {
//            client.setFamily(reattachFamily(clientDto.getFamily()));
//        }
//
//        // If the client has a family, and the family is detached, reattach it
//        if (clientDto.getUser() != null && !entityManager.contains(mapToEntity(clientDto).getUser())) {
//            client.setUser(reattachUser(clientDto.getUser()));
//        }

        client.setAddress(clientDto.getAddress());
        client.setBirthday(clientDto.getBirthday());
        client.setEmail(clientDto.getEmail());
//        client.setFamily(clientDto.getFamily());
        client.setFirstname(clientDto.getFirstname());
        client.setLastname(clientDto.getLastname());
        client.setPhone(clientDto.getPhone());
//        client.setUser(clientDto.getUser());
        client.setIsActive(clientDto.getIsActive());
        client.setPassword(clientDto.getPassword());

        Family family = new Family();
        family.setId(clientDto.getFamily_id());
        client.setFamily(family);

        client.setUser(clientDto.getUser());
        Client updatedClient = clientRepository.save(client);
        return clientHelper.mapToDto(updatedClient);
    }

//    @Override
//    public ClientDto updateClientEmail(ClientDto clientDto, String clientEmail) {
//        Client client = clientRepository.findByEmail(clientEmail).orElseThrow(() -> new ClientNotFoundException("Client could not be updated"));
//
//        client.setAddress(clientDto.getAddress());
//        client.setBirthday(clientDto.getBirthday());
////        client.setEmail(clientDto.getEmail());
//        client.setFamily(clientDto.getFamily());
//        client.setFirstname(clientDto.getFirstname());
//        client.setLastname(clientDto.getLastname());
//        client.setPhone(clientDto.getPhone());
//        client.setUser(clientDto.getUser());
//        client.setIsActive(clientDto.getIsActive());
//
//        Client updatedClient = clientRepository.save(client);
//        return mapToDto(updatedClient);
//    }

//    @Override
//    public ClientDto updateClientPhone(ClientDto clientDto, String clientPhone) {
//        Client client = clientRepository.findByPhone(clientPhone).orElseThrow(() -> new ClientNotFoundException("Client could not be updated"));
//
//        client.setAddress(clientDto.getAddress());
//        client.setBirthday(clientDto.getBirthday());
//        client.setEmail(clientDto.getEmail());
//        client.setFamily(clientDto.getFamily());
//        client.setFirstname(clientDto.getFirstname());
//        client.setLastname(clientDto.getLastname());
////        client.setPhone(clientDto.getPhone());
//        client.setUser(clientDto.getUser());
//        client.setIsActive(clientDto.getIsActive());
//        client.setPassword(clientDto.getPassword());
//
//        Client updatedClient = clientRepository.save(client);
//        return mapToDto(updatedClient);
//    }

    @Override
    public ClientDto deleteClientId(int clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException("Client could not be updated"));
        client.setIsActive(false);

        Client updatedClient = clientRepository.save(client);
        return clientHelper.mapToDto(updatedClient);

    }

//    @Override
//    public ClientDto deleteClientEmail(String clientEmail) {
//        Client client = clientRepository.findByEmail(clientEmail).orElseThrow(() -> new ClientNotFoundException("Client could not be updated"));
//        client.setIsActive(false);
//
//        Client updatedClient = clientRepository.save(client);
//        return mapToDto(updatedClient);
//    }
//
//    @Override
//    public ClientDto deleteClientPhone(String clientPhone) {
//        Client client = clientRepository.findByPhone(clientPhone).orElseThrow(() -> new ClientNotFoundException("Client could not be updated"));
//        client.setIsActive(false);
//
//        Client updatedClient = clientRepository.save(client);
//        return mapToDto(updatedClient);
//    }

    @Override
    public List<ClientDto> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDto> clientDtos = clients.stream().map(p -> clientHelper.mapToDto(p)).collect(Collectors.toList());
        return clientDtos;
    }

    @Override
    public List<ClientDto> getClientByFamilyId(int familyId) {
        List<Client> clients = clientRepository.findByFamilyId(familyId);
        List<ClientDto> clientDtos = clients.stream().map(p -> clientHelper.mapToDto(p)).collect(Collectors.toList());
        return clientDtos;
    }
//
//    private ClientDto mapToDto(Client client) {
//        ClientDto clientDto = new ClientDto();
//        clientDto.setId(client.getId());
//        clientDto.setAddress(client.getAddress());
//        clientDto.setBirthday(client.getBirthday());
//        clientDto.setEmail(client.getEmail());
////        clientDto.setFamily(client.getFamily());
//        clientDto.setFamily_id(client.getFamily().getId());
//        clientDto.setFirstname(client.getFirstname());
//        clientDto.setLastname(client.getLastname());
//        clientDto.setPhone(client.getPhone());
//        clientDto.setUser(client.getUser());
//        clientDto.setIsActive(client.getIsActive());
//        clientDto.setPassword(client.getPassword());
//        return clientDto;
//    }
//
//    private Client mapToEntity(ClientDto clientDto) {
//        Client client = new Client();
//        client.setId(clientDto.getId());
//        client.setAddress(clientDto.getAddress());
//        client.setBirthday(clientDto.getBirthday());
//        client.setEmail(clientDto.getEmail());
////        client.setFamily(clientDto.getFamily());
//        client.setFirstname(clientDto.getFirstname());
//        client.setLastname(clientDto.getLastname());
//        client.setPhone(clientDto.getPhone());
//        client.setUser(clientDto.getUser());
//        client.setIsActive(clientDto.getIsActive());
//        client.setPassword(clientDto.getPassword());
//        return client;
//    }
//
//    // Helper method to reattach a detached Family entity
//    private Family reattachFamily(Family detachedFamily) {
//        // Check if the family is already attached to the current session
//        if (entityManager.contains(detachedFamily)) {
//            return detachedFamily;
//        } else {
//            // If not, reattach the family by fetching it from the database
//            return entityManager.find(Family.class, detachedFamily.getId());
//        }
//    }
//
//    // Helper method to reattach a detached User entity
//    private User reattachUser(User detachedUser) {
//        // Check if the user is already attached to the current session
//        if (entityManager.contains(detachedUser)) {
//            return detachedUser;
//        } else {
//            // If not, reattach the user by fetching it from the database
//            return entityManager.find(User.class, detachedUser.getId());
//        }
//    }
}
