package com.projecttuto.vehicule_rental.mappers;

import com.projecttuto.vehicule_rental.DTO.ClientDTO;
import com.projecttuto.vehicule_rental.entities.Client;

public class ClientDTOMapper {

    public ClientDTO mapToDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setNameClient(client.getNameClient());
        clientDTO.setIdClient(client.getIdClient());
        clientDTO.setCin(client.getCin());
        clientDTO.setBudget(client.getBudget());
        clientDTO.setLocationName(client.getLocation().getName());
        return clientDTO;
    }
}
