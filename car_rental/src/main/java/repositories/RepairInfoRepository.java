package repositories;

import entities.Client;
import entities.Repair;
import entities.RepairInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RepairInfoRepository extends JpaRepository<RepairInfo, Long> {
    public RepairInfo findRepairInfoByRepair(Repair repair);
    public RepairInfo findRepairInfoByClient(Client client);
    public List<RepairInfo> findRepairInfosByDateStart(LocalDate start);

}
