package services;

import entities.Client;
import entities.Subscription;
import entities.Supplier;

public interface SubscriptionService {

    void addSubscription(Subscription subscription);
    void removeSubscription(Subscription subscription);
    void renewSubscription(Subscription subscription);
    Client getClientByEmail(String email);
    Supplier getSupplier(String name);


}
