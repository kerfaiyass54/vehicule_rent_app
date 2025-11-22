package com.projecttuto.vehicule_rental.controllers;


import com.projecttuto.vehicule_rental.DTO.PasswordDTO;
import com.projecttuto.vehicule_rental.DTO.UpdateUserDTO;
import com.projecttuto.vehicule_rental.DTO.UserDTO;
import com.projecttuto.vehicule_rental.services.KeycloakAdminService;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;


@RestController
@RequestMapping("/keycloak")
public class KeycloakController {


    private final KeycloakAdminService keycloakService;

    public KeycloakController(KeycloakAdminService keycloakService) {
        this.keycloakService = keycloakService;
    }


    //use a dto instead
    @PostMapping("/")
    public ResponseEntity<Void> createUser(@RequestBody UserDTO userDTO) {
        keycloakService.createUser(userDTO);
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

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        keycloakService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/user/{id}/password")
    public ResponseEntity<Void> updatePassword(@PathVariable String id,@RequestBody PasswordDTO passwordDTO) {
        keycloakService.updatePassword(id, passwordDTO);
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


    //use a dto instead
    @PutMapping("/user/{userID}/update")
    public ResponseEntity<Void> updateUser(@PathVariable String userID, @RequestBody UpdateUserDTO updateUserDTO)
    {
        keycloakService.updateUserWithoutPassword(userID, updateUserDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }






}
