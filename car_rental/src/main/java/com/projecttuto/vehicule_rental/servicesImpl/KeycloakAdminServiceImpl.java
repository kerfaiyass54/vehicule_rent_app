package com.projecttuto.vehicule_rental.servicesImpl;


import com.projecttuto.vehicule_rental.DTO.UserDTO;
import com.projecttuto.vehicule_rental.repositories.AdminRepository;
import com.projecttuto.vehicule_rental.repositories.ClientRepository;
import com.projecttuto.vehicule_rental.repositories.RepairRepository;
import com.projecttuto.vehicule_rental.repositories.SupplierRepository;
import com.projecttuto.vehicule_rental.services.KeycloakAdminService;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class KeycloakAdminServiceImpl  implements KeycloakAdminService {

    private final Keycloak keycloak;

    @Value("${keycloak.realm}")
    private String userRealm;

    @Value("${keycloak.admin.realm}")
    private String realm;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RepairRepository repairRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public void createUser(UserDTO userDTO) {
        UsersResource users = keycloak.realm(userRealm).users();


        UserRepresentation user = new UserRepresentation();
        user.setUsername(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmailVerified(true);


        user.setEnabled(true);
        Response response = users.create(user);
        if (response.getStatus() != 201) {
            String errorBody = response.readEntity(String.class);
            System.out.println("Keycloak error body: " + errorBody);
            throw new RuntimeException("User creation failed, status: " + response.getStatus() + ", body: " + errorBody);
        }

        String userId = response.getLocation().getPath().replaceAll(".*/([^/]+)$", "$1");
        CredentialRepresentation cred = new CredentialRepresentation();
        cred.setTemporary(false);
        cred.setType(CredentialRepresentation.PASSWORD);
        cred.setValue(userDTO.getPassword());
        users.get(userId).resetPassword(cred);


        RoleRepresentation role = keycloak.realm(userRealm).roles().get(userDTO.getRole()).toRepresentation();
        users.get(userId).roles().realmLevel().add(List.of(role));
    }


    @Override
    public List<UserRepresentation> getAllUsers() {
        return keycloak.realm(realm).users().list();
    }


    @Override
    public void deleteUser(String userId) {
        keycloak.realm(realm).users().delete(userId);
    }

    @Override
    public void updatePassword(String userId,String password, String newPassword, String role) {
        CredentialRepresentation cred = new CredentialRepresentation();
        cred.setTemporary(false);
        cred.setType(CredentialRepresentation.PASSWORD);
        cred.setValue(newPassword);
        keycloak.realm(realm).users().get(userId).resetPassword(cred);
        switch(role){
            case "admin":
                adminRepository.updatePassword(password,newPassword);
                break;
            case "client":
                clientRepository.updatePassword(password,newPassword);
                break;
            case "supplier":
                supplierRepository.updatePassword(password,newPassword);
                break;
            case "repair":
                repairRepository.updatePassword(password,newPassword);
                break;
        }
    }

    @Override
    public List<RoleRepresentation> getAllRoles() {
        return keycloak.realm(realm).roles().list();
    }

    @Override
    public void updateUserWithoutPassword(String userId,String email, String newEmail, String newFirstName, String newLastName, String role){
        UsersResource usersResource = keycloak.realm(realm).users();
        UserRepresentation user = usersResource.get(userId).toRepresentation();
        user.setEmail(newEmail);
        user.setFirstName(newFirstName);
        user.setLastName(newLastName);
        usersResource.get(userId).update(user);
        switch(role){
            case "admin":
                adminRepository.updateEmail(email, newEmail);
                break;
            case "client":
                clientRepository.updateEmail(email, newEmail);
                break;
            case "supplier":
                supplierRepository.updateEmail(email, newEmail);
                break;
            case "repair":
                repairRepository.updateEmail(email, newEmail);
                break;
        }
    }

    public void syncUserToKeycloak(String userName,String firstName,String lastName, String email, String password, String role) {
        UsersResource usersResource = keycloak.realm(userRealm).users();
        List<UserRepresentation> existing = usersResource.search(email, 0, 1);
        if (!existing.isEmpty()) {
            System.out.println(email + " already exists in Keycloak.");
            return;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(firstName);
        userDTO.setLastName(lastName);
        userDTO.setEmail(email);
        userDTO.setPassword(password);
        userDTO.setRole(role);
        createUser(userDTO);
        System.out.println("User synced: " + email);
    }


}
