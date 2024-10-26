package servicesImpl;


import entities.Admin;
import entities.Client;
import entities.Repair;
import entities.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.AdminRepository;
import repositories.ClientRepository;
import repositories.RepairRepository;
import repositories.SupplierRepository;
import services.AdminService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RepairRepository RepairRepository;

    @Autowired
    private SupplierRepository supplierRepository;

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


}
