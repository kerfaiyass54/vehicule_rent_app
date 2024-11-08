package com.projecttuto.vehicule_rental.mappers;

import com.projecttuto.vehicule_rental.DTO.ClientDTO;
import com.projecttuto.vehicule_rental.entities.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientDTOMapper {

    public ClientDTO mapToDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setNameClient(client.getNameClient());
        clientDTO.setIdClient(client.getIdClient());
        clientDTO.setCin(client.getCin());
        clientDTO.setBudget(client.getBudget());
        if(client.getLocation() != null){
            clientDTO.setLocationName(client.getLocation().getName());
        }
        return clientDTO;
    }
}
