package com.example.demo.controller;

import com.example.demo.dto.ClientDto;
import com.example.demo.model.Client;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membership/clients")
public class ClientController {
    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getClients() {
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClientDto> clientDetail(@PathVariable int id) {
        return ResponseEntity.ok(clientService.getClientById(id));

    }

    @GetMapping("family/{familyId}")
    public ResponseEntity<List<ClientDto>> clientDetailByFamily(@PathVariable int familyId) {
        return ResponseEntity.ok(clientService.getClientByFamilyId(familyId));

    }

//    @GetMapping("{email}")
//    public ResponseEntity<ClientDto> clientDetailByEmail(@PathVariable String email) {
//        return ResponseEntity.ok(clientService.getClientByEmail(email));
//    }
//
//    @GetMapping("{phone}")
//    public ResponseEntity<ClientDto> clientDetailByPhone(@PathVariable String phone) {
//        return ResponseEntity.ok(clientService.getClientByPhone(phone));
//    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)  // need family id for create
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto) {
        return new ResponseEntity<>(clientService.createClient(clientDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<ClientDto> updateClientId(@RequestBody ClientDto clientDto, @PathVariable("id") int clientId) {
        ClientDto response = clientService.updateClientId(clientDto, clientId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @PutMapping("/{email}/update")
//    public ResponseEntity<ClientDto> updateClientEmail(@RequestBody ClientDto clientDto, @PathVariable("email") String clientEmail) {
//        ClientDto response = clientService.updateClientEmail(clientDto, clientEmail);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @PutMapping("/{phone}/update")
//    public ResponseEntity<ClientDto> updateClientPhone(@RequestBody ClientDto clientDto, @PathVariable("phone") String clientPhone) {
//        ClientDto response = clientService.updateClientPhone(clientDto, clientPhone);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteClient(@PathVariable("id") int clientId) {
        clientService.deleteClientId(clientId);
        return new ResponseEntity<>("Client delete", HttpStatus.OK);
    }

//    @DeleteMapping("/{email}/delete")
//    public ResponseEntity<String> deleteClientEmail(@PathVariable("email") String clientEmail) {
//        clientService.deleteClientEmail(clientEmail);
//        return new ResponseEntity<>("Client delete", HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{phone}/delete")
//    public ResponseEntity<String> deleteClientPhone(@PathVariable("phone") String clientPhone) {
//        clientService.deleteClientPhone(clientPhone);
//        return new ResponseEntity<>("Client delete", HttpStatus.OK);
//    }
}
