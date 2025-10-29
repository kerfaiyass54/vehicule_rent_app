package com.projecttuto.vehicule_rental.controllers;


import com.projecttuto.vehicule_rental.services.KeycloakAdminService;

import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/keycloak")
public class KeycloakController {


    private final KeycloakAdminService keycloakService;

    public KeycloakController(KeycloakAdminService keycloakService) {
        this.keycloakService = keycloakService;
    }

    @PostMapping("/users")
    public String createUser(@RequestParam String username,
                             @RequestParam String email,
                             @RequestParam String password,
                             @RequestParam String role) {
        keycloakService.createUser(username, email, password, role);
        return "✅ User created successfully!";
    }

    @GetMapping("/users")
    public List<UserRepresentation> getUsers() {
        return keycloakService.getAllUsers();
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable String id) {
        keycloakService.deleteUser(id);
        return "🗑️ User deleted!";
    }

    @PutMapping("/users/{id}/password")
    public String updatePassword(@PathVariable String id, @RequestParam String newPassword) {
        keycloakService.updatePassword(id, newPassword);
        return "🔑 Password updated!";
    }



    @GetMapping("/roles")
    public List<RoleRepresentation> getRoles() {
        return keycloakService.getAllRoles();
    }
}
