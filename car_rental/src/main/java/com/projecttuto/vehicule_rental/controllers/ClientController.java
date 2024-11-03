package com.projecttuto.vehicule_rental.controllers;


import com.projecttuto.vehicule_rental.DTO.ClientDTO;
import com.projecttuto.vehicule_rental.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.projecttuto.vehicule_rental.services.ClientService;

@RestController
@RequestMapping("/client")

public class ClientController {

    @Autowired
    private ClientService clientService;


    @PostMapping("/adding")
    public void addClient(@RequestBody Client client,@RequestParam String locationName){
        clientService.addClient(client,locationName);
    }

    @DeleteMapping
    public void deleteClient(long id){
        clientService.deleteClient(id);
    }

    @GetMapping("/details/{clientName}")
    public ClientDTO getClient(@PathVariable String clientName){
        return clientService.getClient(clientName);
    }

    @PutMapping("/update")
    public void updateClient(ClientDTO clientDTO){
        clientService.updateClient(clientDTO);
    }

    @PostMapping("/password/{nameClient}")
    public void changePassword(@PathVariable String nameClient,@RequestParam String newPassword){
        clientService.changePassword(nameClient,newPassword);
    }

    @GetMapping("/exist/{name}")
    public boolean isClientExist(@PathVariable String name){
        return clientService.isClientExist(name);
    }

    @PostMapping("/budget/{nameClient}")
    public void addToBudget(@RequestParam double budgetExtra,@PathVariable String nameClient){
        clientService.addToBudget(budgetExtra,nameClient);
    }

    @PostMapping("/location/{nameClient}")
    public void changeLocation(@PathVariable String nameClient,@RequestParam String newLocation){
        clientService.changeLocation(nameClient,newLocation);
    }

    @GetMapping("/cin/exist/{cin}")
    public boolean isCinExists(@RequestParam String cin){
        return clientService.isCinExists(cin);
    }
}
