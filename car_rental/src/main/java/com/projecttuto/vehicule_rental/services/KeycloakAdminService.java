package com.projecttuto.vehicule_rental.services;


import org.keycloak.representations.idm.*;
import java.util.List;

public interface KeycloakAdminService {

    public void createUser(String username, String email, String password, String roleName);

    public List<UserRepresentation> getAllUsers();

    public void deleteUser(String userId);

    public void updatePassword(String userId,String password, String newPassword, String role);

    public List<RoleRepresentation> getAllRoles();

    public void updateUserWithoutPassword(String userId,String email, String newEmail, String newFirstName, String newLastName, String role);



}
