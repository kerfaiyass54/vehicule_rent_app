package servicesImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.RepairInfoRepository;
import services.RepairInfoService;

@Service
public class RepairInfoImpl implements RepairInfoService {

    @Autowired
    private RepairInfoRepository repairInfoRepository;
}
