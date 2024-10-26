package repositories;

import entities.Category;
import entities.Client;
import entities.Subscription;
import entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    public List<Subscription> findSubscriptionsByClient(Client client);
    public List<Subscription> findSubscriptionsBySupplier(Supplier supplier);
}
