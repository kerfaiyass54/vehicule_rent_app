package com.projecttuto.vehicule_rental.mappers;

import com.projecttuto.vehicule_rental.DTO.SubscriptionDTO;
import com.projecttuto.vehicule_rental.entities.Subscription;

public class SubscriptionDTOMapper {

    public SubscriptionDTO mapToDTO(Subscription subscription) {
        SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
        subscriptionDTO.setReduce(subscription.getReduce());
        subscriptionDTO.setType(subscription.getType());
        subscriptionDTO.setDateEnd(subscription.getDateEnd());
        subscriptionDTO.setDateStart(subscription.getDateStart());
        subscriptionDTO.setPrice(subscription.getPrice());
        subscriptionDTO.setIdSubscrip(subscription.getIdSubscrip());
        return subscriptionDTO;
    }
}
