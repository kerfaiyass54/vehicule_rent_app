package controllers;


import entities.Buying;
import entities.Client;
import entities.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.BuyingService;

@RestController
@RequestMapping("/buying")
@CrossOrigin(origins = "http://localhost:4200")
public class BuyingController {

    @Autowired
    private BuyingService buyingService;

    @GetMapping("/details/{id}")
    public Buying getBuyingById(@PathVariable long id){
        return buyingService.getBuyingById(id);
    }

    @GetMapping("/vehicule/{vehicule}")
    public Vehicule getVehicule(@PathVariable String vehicule){
        return buyingService.getVehicule(vehicule);
    }


    @GetMapping("/client/{clientName}")
    public Client getClient(@PathVariable String clientName){
        return buyingService.getClient(clientName);
    }


    @DeleteMapping("/{id}")
    public void deleteBuyingById(@PathVariable long id){
        buyingService.deleteBuyingById(id);
    }

    @PostMapping("/buy/{vehiculeName}")
    public void buyVehicule(@PathVariable String vehiculeName,@RequestParam String clientName,@RequestParam int period){
        buyingService.buyVehicule(vehiculeName,clientName,period);
    }

    @GetMapping("/return/{vehiculeName}")
    public void returnVehicule(@PathVariable String vehiculeName,@RequestParam String clientName){
        buyingService.returnVehicule(vehiculeName,clientName);
    }
}
