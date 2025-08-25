package com.projecttuto.vehicule_rental.controllers;


import com.projecttuto.vehicule_rental.DTO.ClientDTO;
import com.projecttuto.vehicule_rental.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.projecttuto.vehicule_rental.services.ClientService;

@RestController
@RequestMapping("/client")
@CrossOrigin("*")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @PostMapping("/adding")
    public void addClient(@RequestBody Client client,@RequestParam String locationName){
        clientService.addClient(client,locationName);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable long id){
        clientService.deleteClient(id);
    }

    @GetMapping("/details/{clientName}")
    public ClientDTO getClient(@PathVariable String clientName){
        return clientService.getClient(clientName);
    }

    @PutMapping("/update")
    public void updateClient(@RequestBody ClientDTO clientDTO){
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

    @GetMapping("/location/{nameClient}")
    public void changeLocation(@PathVariable String nameClient,@RequestParam String newLocation){
        clientService.changeLocation(nameClient,newLocation);
    }

    @GetMapping("/cin/exist/{cin}")
    public boolean isCinExists(@PathVariable String cin){
        return clientService.isCinExists(cin);
    }
}
