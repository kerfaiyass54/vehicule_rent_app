package com.projecttuto.vehicule_rental.servicesImpl;


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

    @Value("${keycloak.users.realm.name}")
    private String userRealm;

    @Value("${keycloak.realm}")
    private String realm;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RepairRepository RepairRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public void createUser(String username, String email, String password, String roleName) {
        UsersResource users = keycloak.realm(userRealm).users();


        UserRepresentation user = new UserRepresentation();
        user.setUsername(username);
        user.setEmail(email);


        Response response = users.create(user);
        if (response.getStatus() != 201) {
            throw new RuntimeException("User creation failed, status: " + response.getStatus());
        }

        String userId = response.getLocation().getPath().replaceAll(".*/([^/]+)$", "$1");


        CredentialRepresentation cred = new CredentialRepresentation();
        cred.setTemporary(false);
        cred.setType(CredentialRepresentation.PASSWORD);
        cred.setValue(password);
        users.get(userId).resetPassword(cred);


        RoleRepresentation role = keycloak.realm(realm).roles().get(roleName).toRepresentation();
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
    public void updatePassword(String userId, String newPassword) {
        CredentialRepresentation cred = new CredentialRepresentation();
        cred.setTemporary(false);
        cred.setType(CredentialRepresentation.PASSWORD);
        cred.setValue(newPassword);
        keycloak.realm(realm).users().get(userId).resetPassword(cred);
    }

    @Override
    public List<RoleRepresentation> getAllRoles() {
        return keycloak.realm(realm).roles().list();
    }

    @Override
    public void updateUserWithoutPassword(String userId, String newEmail, String newFirstName, String newLastName, String role){
        UsersResource usersResource = keycloak.realm(realm).users();
        UserRepresentation user = usersResource.get(userId).toRepresentation();
        user.setEmail(newEmail);
        user.setFirstName(newFirstName);
        user.setLastName(newLastName);
        usersResource.get(userId).update(user);
    }

    public void updateEmail(String email, String role){
        
    }


}
