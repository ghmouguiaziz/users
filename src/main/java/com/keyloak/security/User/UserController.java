package com.keyloak.security.User;

import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private  KeycloakAdminService keycloakAdminService; // Service to interact with Keycloak Admin Client

    @PostMapping("/create")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<String> createUser(@RequestBody UserRepresentation user) {
        try {
            keycloakAdminService.createUser(user);
            return ResponseEntity.ok("User created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create user: " + e.getMessage());
        }
    }

    @GetMapping("/getAll")
    //@PreAuthorize("hasRole('admin')")
    public List<UserRepresentation> getAllUsers() {
        return keycloakAdminService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserRepresentation getUserById(@PathVariable String userId) {
        return keycloakAdminService.getUserById(userId);
    }

    @PutMapping("/{userId}/update")
    public ResponseEntity<String> updateUser(@PathVariable String userId, @RequestBody UserRepresentation user) {
        try {
            keycloakAdminService.updateUser(userId, user);
            return ResponseEntity.ok("User updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update user: " + e.getMessage());
        }
    }

    @DeleteMapping("/{userId}/delete")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        try {
            keycloakAdminService.deleteUser(userId);
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete user: " + e.getMessage());
        }
    }
}
