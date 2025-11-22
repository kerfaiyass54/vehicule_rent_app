package com.projecttuto.vehicule_rental.services;


import com.projecttuto.vehicule_rental.DTO.PasswordDTO;
import com.projecttuto.vehicule_rental.DTO.UserDTO;
import org.keycloak.representations.idm.*;
import java.util.List;

public interface KeycloakAdminService {

    public void createUser(UserDTO userDTO);

    public List<UserRepresentation> getAllUsers();

    public void deleteUser(String userId);

    public void updatePassword(String userId, PasswordDTO passwordDTO);

    public List<RoleRepresentation> getAllRoles();

    public void updateUserWithoutPassword(String userId,String email, String newEmail, String newFirstName, String newLastName, String role);



}
