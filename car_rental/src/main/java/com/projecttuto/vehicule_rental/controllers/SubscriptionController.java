package com.projecttuto.vehicule_rental.controllers;
import com.projecttuto.vehicule_rental.DTO.SubscriptionDTO;
import com.projecttuto.vehicule_rental.entities.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.projecttuto.vehicule_rental.services.SubscriptionService;

@RestController
@RequestMapping("/subs")
@CrossOrigin("*")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping("/add")
    public void addSubscription(@RequestBody Subscription subscription,@RequestParam String emailClient,@RequestParam String nameSupplier){
        subscriptionService.addSubscription(subscription,emailClient,nameSupplier);
    }

    @PostMapping("/remove")
    public void removeSubscription(@RequestBody Subscription subscription){
        subscriptionService.removeSubscription(subscription);
    }

    @PostMapping("/renew/{nameClient}")
    public void renewSubscription(@RequestBody Subscription subscription,@PathVariable String nameClient,@RequestParam int time){
        subscriptionService.renewSubscription(subscription,nameClient,time);
    }

    @GetMapping("/subscript/{emailClient}")
    public boolean isClientSubscript(@PathVariable String emailClient,@RequestParam String nameSupplier){
        return subscriptionService.isClientSubscript(emailClient,nameSupplier);
    }

    @GetMapping("/get/{nameSupplier}")
    public SubscriptionDTO getSubscription(@RequestParam String emailClient,@PathVariable String nameSupplier){
        return subscriptionService.getSubscription(emailClient,nameSupplier);
    }


}
