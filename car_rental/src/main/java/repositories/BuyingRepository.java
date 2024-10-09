package repositories;

import entities.Buying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyingRepository extends JpaRepository<Buying, Long> {
}
