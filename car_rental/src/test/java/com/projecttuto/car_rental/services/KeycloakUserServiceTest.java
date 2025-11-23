package com.projecttuto.car_rental.services;

import com.projecttuto.vehicule_rental.servicesImpl.KeycloakAdminServiceImpl;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class KeycloakUserServiceTest {

    @Mock
    private Keycloak keycloak;

    @Mock
    private RealmResource realmResource;

    @Mock
    private UsersResource usersResource;

    @InjectMocks
    private KeycloakAdminServiceImpl keycloakUserService;

    public KeycloakUserServiceTest() {
        MockitoAnnotations.openMocks(this);
    }
}
