package repositories;

import entities.Category;
import entities.Demand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DemandRepository extends JpaRepository<Demand, Long> {
    public List<Demand> findDemandsByDateAsk(LocalDate date);

}
