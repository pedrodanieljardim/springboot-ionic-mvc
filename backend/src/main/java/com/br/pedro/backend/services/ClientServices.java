package com.br.pedro.backend.services;

import com.br.pedro.backend.domains.Category;
import com.br.pedro.backend.domains.Client;
import com.br.pedro.backend.exceptions.ObjectNotFoundException;
import com.br.pedro.backend.repositories.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ClientServices {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll(){
        log.info("Fazendo busca de todos clientes!");
        return clientRepository.findAll();
    }

    public Client searchCategoryById(Long id){
        log.info("Fazendo busca por id de client {}!", id);
        return clientRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado pelo Id!"));
    }

    public Client createClient(Client client){
        log.info("Criando cliente!");
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client newClient){
        Client oldClient = clientRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado pelo Id!"));

        oldClient.setName(newClient.getName());
        oldClient.setEmail(newClient.getEmail());
        oldClient.setDocument(newClient.getDocument());
        oldClient.setAdressList(newClient.getAdressList());
        oldClient.setTypeClient(newClient.getTypeClient());
        oldClient.setContactCell(newClient.getContactCell());
        oldClient.setContactPhone(newClient.getContactPhone());

        return clientRepository.save(oldClient);
    }

    public void removeClient(Long id){
        Client deletedCategory = clientRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada pelo Id!"));
        clientRepository.deleteById(deletedCategory.getId());
    }





}
