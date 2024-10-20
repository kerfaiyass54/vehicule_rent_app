package servicesImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.RepairInfoRepository;
import repositories.RepairRepository;
import repositories.VehiculeRepository;
import services.RepairInfoService;

@Service
public class RepairInfoServiceImpl implements RepairInfoService {

    @Autowired
    private RepairInfoRepository repairInfoRepository;

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Autowired
    private RepairRepository repairRepository;

}
