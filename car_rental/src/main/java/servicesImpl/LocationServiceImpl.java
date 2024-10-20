package servicesImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.AdressRepository;
import repositories.ClientRepository;
import repositories.LocationRepository;
import repositories.RepairRepository;
import services.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private RepairRepository repairRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AdressRepository adressRepository;


}
