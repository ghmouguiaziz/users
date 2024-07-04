package com.keyloak.security.User;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeycloakAdminService {

    @Autowired
    private Keycloak keycloak;

    public void createUser(org.keycloak.representations.idm.UserRepresentation user) {
        UsersResource usersResource = keycloak.realm("MTCsecurity").users();
        usersResource.create(user);
    }

    public List<UserRepresentation> getAllUsers() {
        UsersResource usersResource = keycloak.realm("MTCsecurity").users();
        return usersResource.list();
    }

    public UserRepresentation getUserById(String userId) {
        UsersResource usersResource = keycloak.realm("MTCsecurity").users();
        return usersResource.get(userId).toRepresentation();
    }

    public void updateUser(String userId, UserRepresentation user) {
        UsersResource usersResource = keycloak.realm("MTCsecurity").users();
        usersResource.get(userId).update(user);
    }

    public void deleteUser(String userId) {
        UsersResource usersResource = keycloak.realm("MTCsecurity").users();
        usersResource.get(userId).remove();
    }
}
