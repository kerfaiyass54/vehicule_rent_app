package com.projecttuto.vehicule_rental.services;

import com.projecttuto.vehicule_rental.entities.UserLoginSession;

import java.time.LocalDate;
import java.util.List;

public interface UserLoginSessionService {

    public UserLoginSession saveSession(String username, String email);

    public List<UserLoginSession> findAllUserLoginSessions();

    public List<UserLoginSession> findAllUserLoginSessionsByEmail(String email);

    public List<UserLoginSession> findAllUserLoginSessionsByLoginDate(LocalDate loginDate);
}
