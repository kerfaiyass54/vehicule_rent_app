package services;

import DTO.SubscriptionDTO;
import entities.Client;
import entities.Subscription;
import entities.Supplier;

public interface SubscriptionService {

    void addSubscription(Subscription subscription, String emailClient, String nameSupplier);
    void removeSubscription(Subscription subscription);
    void renewSubscription(Subscription subscription, String nameClient, int time);
    Client getClientByEmail(String email);
    Supplier getSupplier(String name);
    boolean isClientSubscript(String emailClient, String nameSupplier);
    SubscriptionDTO getSubscription(String emailClient, String nameSupplier);


}
