package servicesImpl;

import DTO.UserDTO;
import entities.Client;
import entities.Repair;
import entities.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ClientRepository;
import repositories.RepairRepository;
import repositories.SupplierRepository;
import services.AuthenticationService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private RepairRepository   repairRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public void signUpUser(UserDTO user){
        
    }

    @Override
    public boolean isEmailExist(String email){
        return getAllMails().contains(email);
    }

    public List<String> getAllMails(){
        List<Supplier> suppliers = supplierRepository.findAll();
        List<Client> clients = clientRepository.findAll();
        List<Repair> repairs = repairRepository.findAll();
        List<String> mails = new ArrayList<String>();
        for(Supplier s : suppliers){
            mails.add(s.getEmail());
        }
        for(Client c : clients){
            mails.add(c.getEmail());
        }
        for(Repair r : repairs){
            mails.add(r.getEmail());
        }

        return mails;
    }


}
