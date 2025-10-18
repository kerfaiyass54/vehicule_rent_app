package com.projecttuto.vehicule_rental.servicesImpl;


import com.projecttuto.vehicule_rental.DTO.ClientDTO;
import com.projecttuto.vehicule_rental.entities.Client;
import com.projecttuto.vehicule_rental.entities.Location;
import com.projecttuto.vehicule_rental.repositories.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.projecttuto.vehicule_rental.services.ClientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public void addClient(Client client, String locationName) {
        Optional<Location> location = locationRepository.findByName(locationName);
            client.setLocation(location.get());
            clientRepository.save(client);

    }

    @Override
    public ClientDTO getClient(String clientName){
        ClientDTO clientDTO = new ClientDTO();
        Client client = clientRepository.findClientByNameClient(clientName);
        clientDTO.setIdClient(client.getIdClient());
        clientDTO.setNameClient(client.getNameClient());
        clientDTO.setBudget(client.getBudget());
        if(client.getLocation() != null){
            clientDTO.setLocationName(client.getLocation().getName());
        }
        return clientDTO;
    }


    public List<String> getEmails(){
        List<Client> clients = clientRepository.findAll();
        List<String> emails = new ArrayList<String>();
        for(Client client : clients){
            emails.add(client.getEmail());
        }
        return emails;
    }

    @Override
    public void updateClient(ClientDTO clientDTO){
        Client client = clientRepository.findById(clientDTO.getIdClient()).get();
        client.setNameClient(clientDTO.getNameClient());
        client.setBudget(clientDTO.getBudget());
        clientRepository.save(client);

    }

    @Override
    public void changePassword(String nameClient, String newPassword){
        Client client = clientRepository.findClientByNameClient(nameClient);
        client.setPass(newPassword);
        clientRepository.save(client);
    }



    @Override
    public void deleteClient(long id){
        clientRepository.delete(clientRepository.findById(id).get());
    }

    @Override
    public void addToBudget(double budgetExtra, String nameClient){
        Client client = clientRepository.findClientByNameClient(nameClient);
        client.setBudget(client.getBudget() + budgetExtra);
        clientRepository.save(client);
    }

    @Override
    public void changeLocation(String nameClient, String newLocation){
        Client client = clientRepository.findByNameClient(nameClient).get();
        client.setLocation(locationRepository.findByName(newLocation).get());
        clientRepository.save(client);
    }





    @Override
    public Page<Client> listOfClients(int page, int size, String search){
        Pageable pageable = PageRequest.of(page, size);
        if (search != null && !search.isEmpty()) {
            return clientRepository.findClientByNameClient(search, pageable);
        }
        return clientRepository.findAll(pageable);
    }



}
