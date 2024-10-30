package servicesImpl;


import entities.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.*;
import services.AdminService;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RepairRepository RepairRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    @Override
    public List<Repair> getRepairs(){
        return RepairRepository.findAll();
    }

    @Override
    public List<Supplier> getSuppliers(){
        return supplierRepository.findAll();
    }

    @Override
    public void updateDetails(Admin admin){
        Admin a = adminRepository.findAdminByAdminName(admin.getAdminName());
        a.setAdminName(admin.getAdminName());
        a.setEmail(admin.getEmail());
        a.setPass(admin.getPass());
        adminRepository.save(a);
    }

    @Override
    public Admin getDetails(String adminName){
        return adminRepository.findAdminByAdminName(adminName);
    }

    @Override
    public List<Location> getLocations(){
        return locationRepository.findAll();
    }


}
