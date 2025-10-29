package com.projecttuto.vehicule_rental.services;

import org.keycloak.representations.account.UserRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;

import java.util.List;

public interface KeycloakAdminService {

    public void createUser(String username, String email, String password, String roleName);

    public List<UserRepresentation> getAllUsers();

    public void deleteUser(String userId);

    public void updatePassword(String userId, String newPassword);

    public void createRole(String roleName);

    public List<RoleRepresentation> getAllRoles();



}
