package com.br.pedro.backend.controllers;

import com.br.pedro.backend.domains.Category;
import com.br.pedro.backend.domains.Client;
import com.br.pedro.backend.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientServices clientServices;

    @GetMapping
    public List<Client> findAllCategories(){
        return clientServices.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findCategoryById(@PathVariable("id") Long clientId){
        return ResponseEntity.ok().body(clientServices.searchCategoryById(clientId));
    }

    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody Client client){
        Client newClient = clientServices.createClient(client);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newClient.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateClient(@PathVariable("id") Long clientId, @RequestBody Client client){
        clientServices.updateClient(clientId, client);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") Long clientId){
        clientServices.removeClient(clientId);
        return ResponseEntity.noContent().build();
    }


}
