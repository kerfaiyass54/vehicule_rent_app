package com.projecttuto.vehicule_rental.servicesImpl;


import com.projecttuto.vehicule_rental.DTO.ClientDTO;
import com.projecttuto.vehicule_rental.entities.Admin;
import com.projecttuto.vehicule_rental.entities.Client;
import com.projecttuto.vehicule_rental.entities.Location;
import com.projecttuto.vehicule_rental.repositories.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projecttuto.vehicule_rental.services.ClientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        clientDTO.setCin(client.getCin());
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
        Client client = clientRepository.getById(clientDTO.getIdClient());
        client.setNameClient(clientDTO.getNameClient());
        client.setCin(clientDTO.getCin());
        client.setBudget(clientDTO.getBudget());
        client.setEmail(clientDTO.getEmail());
        clientRepository.save(client);
    }

    @Override
    public void changePassword(String nameClient, String newPassword){
        Client client = clientRepository.findClientByNameClient(nameClient);
        client.setPass(newPassword);
        clientRepository.save(client);
    }

    @Override
    public boolean isClientExist(String name){
        List<Client> clients = clientRepository.findAll();
        List<String> names = new ArrayList<>();
        for(Client client : clients){
            names.add(client.getNameClient());
        }
        return names.contains(name);
    }

    @Override
    public void deleteClient(long id){
        Client client = clientRepository.getById(id);
        if(client.getSubscriptions().isEmpty() && client.getBuyings().isEmpty()){
            Location location = locationRepository.findLocationByName(client.getLocation().getName());
            location.getClients().remove(client);
            Admin admin = adminRepository.findAdminByAdminName(client.getAdmin().getAdminName());
            admin.getClients().remove(client);
            locationRepository.save(location);
            adminRepository.save(admin);
            clientRepository.delete(client);
        }
    }

    @Override
    public void addToBudget(double budgetExtra, String nameClient){
        Client client = clientRepository.findClientByNameClient(nameClient);
        client.setBudget(client.getBudget() + budgetExtra);
        clientRepository.save(client);
    }

    @Override
    public void changeLocation(String nameClient, String newLocation){
        Client client = clientRepository.findClientByNameClient(nameClient);
        Location location = locationRepository.findLocationByName(client.getLocation().getName());
        if(!Objects.equals(client.getLocation().getName(), location.getName())){
            client.setLocation(location);
            locationRepository.save(location);
        }

    }



    @Override
    public boolean isCinExists(String cin){
        List<Client> clients = clientRepository.findAll();
        boolean cinExists = false;
        for(Client client : clients){
            if(client.getCin().equals(cin)){
                cinExists = true;
            }
        }
        return cinExists;
    }




}
