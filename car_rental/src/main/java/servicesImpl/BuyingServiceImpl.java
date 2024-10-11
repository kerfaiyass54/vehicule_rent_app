package servicesImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.BuyingRepository;
import services.BuyingService;

@Service
public class BuyingServiceImpl implements BuyingService {

    @Autowired
    private BuyingRepository buyingRepository;

}
