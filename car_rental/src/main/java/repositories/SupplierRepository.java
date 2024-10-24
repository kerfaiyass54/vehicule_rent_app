package repositories;

import entities.Category;
import entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    public Supplier findSupplierBySuppName(String name);
}
