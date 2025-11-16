package com.projecttuto.vehicule_rental.controllers;


import com.projecttuto.vehicule_rental.services.KeycloakAdminService;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Void> createUser(@RequestParam String username,
                                     @RequestParam String email,
                                     @RequestParam String password,
                                     @RequestParam String role) {
        keycloakService.createUser(username, email, password, role);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserRepresentation>> getUsers() {
        List<UserRepresentation> users = keycloakService.getAllUsers();
        if(users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        keycloakService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/users/{id}/password")
    public ResponseEntity<Void> updatePassword(@PathVariable String id, @RequestParam String newPassword) {
        keycloakService.updatePassword(id, newPassword);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }



    @GetMapping("/roles")
    public ResponseEntity<List<RoleRepresentation>> getRoles() {
        List<RoleRepresentation> roles = keycloakService.getAllRoles();
        if(roles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(roles);
    }




}
